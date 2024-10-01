package co.com.giovanni.franquicias.service;

import co.com.giovanni.franquicias.dto.FranquiciaDTO;

/**
 * La interface IFranquiciaService es responsable de la adminitracion de la entidad franquicias.
 * @author GIOVANNI
 * @since 2024-09-30
 */
public interface IFranquiciaService {

    /**
     * Metodo en cargado de la creación de la Franquicia
     * @author GIOVANNI
     * @param franquiciaDTO
     * @since 2024-09-30
     * @return void
     */
    void saveFranquicia(FranquiciaDTO franquiciaDTO);
}
