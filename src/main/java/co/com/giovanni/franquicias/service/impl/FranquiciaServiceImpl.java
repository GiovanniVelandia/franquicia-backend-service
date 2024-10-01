package co.com.giovanni.franquicias.service.impl;

import co.com.giovanni.franquicias.dto.FranquiciaDTO;
import co.com.giovanni.franquicias.model.Franquicia;
import co.com.giovanni.franquicias.repository.IFranquiciaRepository;
import co.com.giovanni.franquicias.service.IFranquiciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * La clase FranquiciaServiceImpl es responsable de administrar las franquicia.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class FranquiciaServiceImpl implements IFranquiciaService {

    private final IFranquiciaRepository iFranquiciaRepository;
    private final ModelMapper modelMapper;

    @Override
    public void saveFranquicia(FranquiciaDTO franquiciaDTO) {
        iFranquiciaRepository.save(modelMapper.map(franquiciaDTO, Franquicia.class));
    }
}
