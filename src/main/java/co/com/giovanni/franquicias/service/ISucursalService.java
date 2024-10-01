package co.com.giovanni.franquicias.service;

import co.com.giovanni.franquicias.dto.SucursalDTO;

/**
 * La interface ISucursalService es responsable de la adminitracion de la entidad Sucursal.
 * @author GIOVANNI
 * @since 2024-09-30
 */
public interface ISucursalService {

    /**
     * Metodo en cargado de la creación de la Sucursal
     * @author GIOVANNI
     * @param sucursalDTO
     * @since 2024-09-30
     * @return void
     */
    void saveSucursal(SucursalDTO sucursalDTO);

    /**
     * Metodo en cargado de modificar un Sucursal campo nombre
     * @author GIOVANNI
     * @param idSucursal
     * @param nombre
     * @since 2024-09-30
     * @return void
     */
    void modificarNombre(Integer idSucursal, String nombre);
}
