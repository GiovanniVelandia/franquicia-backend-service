package co.com.giovanni.franquicias.controller;

import co.com.giovanni.franquicias.dto.FranquiciaDTO;
import co.com.giovanni.franquicias.service.IFranquiciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * La clase FranquiciaController es responsable de manejar las solicitudes HTTP relacionadas con los franquicias.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/franquicia")
public class FranquiciaController {

    private final IFranquiciaService iFranquiciaService;

    /**
     * Metodo en cargado de la guargar una Franquicia
     * @author GIOVANNI
     * @param franquiciaDTO
     * @since 2024-09-30
     * @return void
     */
    @PostMapping("/crear")
    public void saveFranquicia(@RequestBody FranquiciaDTO franquiciaDTO) {
        log.info("saveFranquicia(FranquiciaDTO)");
        iFranquiciaService.saveFranquicia(franquiciaDTO);
    }
}
