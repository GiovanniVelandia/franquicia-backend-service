package co.com.giovanni.franquicias.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * La clase ApplicationConfig es responsable de las configuraciones y definiciones de beans utilizados en toda la aplicacion.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@Configuration
public class ApplicationConfig {

    /**
     * Metodo en cargado de la configuracion para le modelMaper para mapear objetos de un tipo a otro
     * @author GIOVANNI
     * @since 2024-09-30
     * @return void
     */
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }
}
