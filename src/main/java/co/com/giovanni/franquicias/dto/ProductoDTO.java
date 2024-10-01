package co.com.giovanni.franquicias.dto;

import lombok.Data;

/**
 * La clase ProductoDTO es un objeto de transferencia de datos (DTO) que representa la información básica de un producto.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Data
public class ProductoDTO {

    private Integer id;
    private String nombre;
    private Integer stock;
    private SucursalDTO sucursal;
}
