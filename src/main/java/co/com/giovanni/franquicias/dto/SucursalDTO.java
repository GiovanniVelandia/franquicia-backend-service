package co.com.giovanni.franquicias.dto;

import lombok.Data;

/**
 * La clase SucursalDTO es un objeto de transferencia de datos (DTO) que representa la información básica de una sucursal.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Data
public class SucursalDTO {

    private Integer id;
    private String nombre;
    private FranquiciaDTO franquicia;
}
