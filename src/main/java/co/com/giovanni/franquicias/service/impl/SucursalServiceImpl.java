package co.com.giovanni.franquicias.service.impl;

import co.com.giovanni.franquicias.dto.SucursalDTO;
import co.com.giovanni.franquicias.model.Producto;
import co.com.giovanni.franquicias.model.Sucursal;
import co.com.giovanni.franquicias.repository.ISucursalRepository;
import co.com.giovanni.franquicias.service.ISucursalService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * La clase FranquiciaServiceImpl es responsable de administrar las sucursales.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class SucursalServiceImpl implements ISucursalService {

    private final ISucursalRepository iSucursalRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveSucursal(SucursalDTO sucursalDTO) {
        iSucursalRepository.save(modelMapper.map(sucursalDTO, Sucursal.class));
    }

    @Override
    public void modificarNombre(Integer idSucursal, String nombre) {
        log.info("modificarNombre(Integer, String)");

        Optional<Sucursal> sucursal = iSucursalRepository.findById(idSucursal);

        sucursal.ifPresentOrElse(
                p -> {
                    p.setNombre(nombre);
                    iSucursalRepository.save(p);
                },
                () -> {
                    throw new EntityNotFoundException("Sucursal no encontrado");
                }
        );
    }
}
