package co.com.giovanni.franquicias.controller;

import co.com.giovanni.franquicias.dto.SucursalDTO;
import co.com.giovanni.franquicias.service.ISucursalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * La clase SucursalController es responsable de manejar las solicitudes HTTP relacionadas con los sucursales.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/sucursal")
public class SucursalController {

    private final ISucursalService iSucursalService;

    /**
     * Metodo en cargado de la guargar una Sucursal
     * @author GIOVANNI
     * @param sucursalDTO
     * @since 2024-09-30
     * @return void
     */
    @PostMapping("/crear")
    public void saveSucursal(@RequestBody SucursalDTO sucursalDTO) {
        log.info("saveSucursal(SucursalDTO)");
        iSucursalService.saveSucursal(sucursalDTO);
    }
}
