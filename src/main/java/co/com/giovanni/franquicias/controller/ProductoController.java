package co.com.giovanni.franquicias.controller;

import co.com.giovanni.franquicias.dto.ProductoDTO;
import co.com.giovanni.franquicias.dto.ProductoResponseDTO;
import co.com.giovanni.franquicias.service.IProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * La clase ProductoController es responsable de manejar las solicitudes HTTP relacionadas con los productos.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/producto")
public class ProductoController {

    private final IProductoService iProductoService;

    /**
     * Metodo en cargado de consultar los productos
     * @author GIOVANNI
     * @since 2024-09-30
     * @return List<ProductoDTO>
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<ProductoDTO>> findAll() {
        log.info("findAll()");
        return ResponseEntity.ok(iProductoService.findAll());
    }

    /**
     * Metodo en cargado de la guargar un producto
     * @author GIOVANNI
     * @param productoDTO
     * @since 2024-09-30
     * @return void
     */
    @PostMapping("/crear")
    public ResponseEntity<String> saveProducto(@RequestBody ProductoDTO productoDTO) {
        log.info("saveProducto(ProductoDTO)");
        iProductoService.saveProducto(productoDTO);
        return ResponseEntity.ok("Producto creado exitosamente");
    }

    /**
     * Metodo en cargado de eliminar un producto
     * @author GIOVANNI
     * @param idProducto
     * @since 2024-09-30
     * @return String
     */
    @DeleteMapping("/eliminar/{idProducto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long idProducto) {
        log.info("eliminarProducto(Long)");
        iProductoService.eliminarProducto(idProducto);
        return ResponseEntity.ok("Producto eliminado exitosamente");
    }

    /**
     * Metodo en cargado de modificar el stock de un producto
     * @author GIOVANNI
     * @param idProducto
     * @param nuevoStock
     * @since 2024-09-30
     * @return String
     */
    @PatchMapping("/{idProducto}/stock")
    public ResponseEntity<String> modificarStock(@PathVariable Long idProducto,
                                                 @RequestParam Integer nuevoStock) {
        log.info("modificarStock(Long, Integer)");
        iProductoService.modificarStock(idProducto, nuevoStock);
        return ResponseEntity.ok("Producto modificado exitosamente");
    }

    /**
     * Metodo en cargado de obtener el stock mayor de un producto dado la franquicia
     * @author GIOVANNI
     * @param idFranquicia
     * @since 2024-09-30
     * @return List<ProductoResponseDTO>
     */
    @GetMapping("/{idFranquicia}/productos-max-stock")
    public ResponseEntity<List<ProductoResponseDTO>> obtenerProductosMayorStockSucursal(
                                                                    @PathVariable Long idFranquicia) {
        log.info("obtenerProductosMayorStockSucursal(Long)");
        return ResponseEntity.ok(iProductoService.obtenerProductosMayorStockSucursal(idFranquicia));
    }
}
