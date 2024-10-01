package co.com.giovanni.franquicias.service;

import co.com.giovanni.franquicias.dto.ProductoDTO;
import co.com.giovanni.franquicias.dto.ProductoResponseDTO;

import java.util.List;

/**
 * La interface IProductoService es responsable de la adminitracion de la entidad producto.
 * @author GIOVANNI
 * @since 2024-09-30
 */
public interface IProductoService {

    /**
     * Metodo en cargado de consultar todos los productos
     * @author GIOVANNI
     * @since 2024-09-30
     * @return List<ProductoDTO>
     */
    List<ProductoDTO> findAll();

    /**
     * Metodo en cargado de la creación de la Producto
     * @author GIOVANNI
     * @param productoDTO
     * @since 2024-09-30
     * @return void
     */
    void saveProducto(ProductoDTO productoDTO);

    /**
     * Metodo en cargado de eliminar un Producto
     * @author GIOVANNI
     * @param idProducto
     * @since 2024-09-30
     * @return void
     */
    void eliminarProducto(Long idProducto);

    /**
     * Metodo en cargado de modificar un Producto
     * @author GIOVANNI
     * @param idProducto
     * @since 2024-09-30
     * @return void
     */
    void modificarStock(Long idProducto, Integer nuevoStock);

    /**
     * Metodo en cargado de consultar el mayo stock por sucursal
     * @author GIOVANNI
     * @param idFranquicia
     * @since 2024-09-30
     * @return List<ProductoResponseDTO>
     */
    List<ProductoResponseDTO> obtenerProductosMayorStockSucursal(Long idFranquicia);
}
