package co.com.giovanni.franquicias.dto;

import lombok.Builder;
import lombok.Data;

/**
 * La clase ProductoResponseDTO es un objeto de transferencia de datos (DTO).
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Data
@Builder
public class ProductoResponseDTO {

    private ProductoDTO producto;
    private SucursalDTO sucursal;
}
