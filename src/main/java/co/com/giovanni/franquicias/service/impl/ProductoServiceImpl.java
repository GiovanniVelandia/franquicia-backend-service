package co.com.giovanni.franquicias.service.impl;

import co.com.giovanni.franquicias.dto.ProductoDTO;
import co.com.giovanni.franquicias.dto.ProductoResponseDTO;
import co.com.giovanni.franquicias.dto.SucursalDTO;
import co.com.giovanni.franquicias.model.Producto;
import co.com.giovanni.franquicias.model.Sucursal;
import co.com.giovanni.franquicias.repository.IProductoRepository;
import co.com.giovanni.franquicias.service.IProductoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * La clase ProductoServiceImpl es responsable de administrar las Producto.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final IProductoRepository iProductoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductoDTO> findAll() {
        log.info("findAll()");
        List<Producto> productos = iProductoRepository.findAll();

        return productos.stream() 
                .map(producto -> modelMapper.map(producto, ProductoDTO.class)) 
                .collect(Collectors.toList());
    }

    @Override
    public void saveProducto(ProductoDTO productoDTO) {
        log.info("saveProducto(ProductoDTO)");
        iProductoRepository.save(Optional.ofNullable(productoDTO)
                .map(dto -> modelMapper.map(dto, Producto.class))
                .orElseThrow(() -> new IllegalArgumentException("ProductoDTO no puede ser nulo")));
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        log.info("eliminarProducto(Long)");

        Optional<Producto> producto = iProductoRepository.findById(idProducto);

        producto.ifPresentOrElse(
                p -> iProductoRepository.deleteById(idProducto),
                () -> { throw new EntityNotFoundException("Producto con ID " + idProducto + " no encontrado."); }
        );
    }

    @Override
    public void modificarStock(Long idProducto, Integer nuevoStock) {
        log.info("modificarStock(Long, Integer)");

        Optional<Producto> producto = iProductoRepository.findById(idProducto);

        producto.ifPresentOrElse(
                p -> {
                    p.setStock(nuevoStock);
                    iProductoRepository.save(p);
                },
                () -> {
                    throw new EntityNotFoundException("Producto no encontrado");
                }
        );
    }

    @Override
    public List<ProductoResponseDTO> obtenerProductosMayorStockSucursal(Long idFranquicia) {
        log.info("obtenerProductosMayorStockSucursal(Long)");

        List<Producto> productos = iProductoRepository.findByFranquicia(idFranquicia);

        Map<Sucursal, Producto> maxStockPorSucursal = new HashMap<>();

        for (Producto producto : productos) {
            Sucursal sucursal = producto.getSucursal();
            if (!maxStockPorSucursal.containsKey(sucursal) ||
                    producto.getStock() > maxStockPorSucursal.get(sucursal).getStock()) {
                maxStockPorSucursal.put(sucursal, producto);
            }
        }

        return maxStockPorSucursal.entrySet().stream()
                .map(entry -> ProductoResponseDTO.builder()
                        .sucursal(modelMapper.map(entry.getKey(), SucursalDTO.class))
                        .producto(modelMapper.map(entry.getValue(), ProductoDTO.class))
                        .build())
                .collect(Collectors.toList());
    }
}