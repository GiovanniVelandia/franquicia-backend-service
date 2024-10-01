package co.com.giovanni.franquicias.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * La clase GlobalExceptionHandler es responsable de capturar las Exceptiones.
 * @author GIOVANNI
 * @since 2024-09-30
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Metodo en cargado de la capturar las Exception NOT_FOUND
     * @author GIOVANNI
     * @param ex
     * @since 2024-09-30
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleNotFound(Exception ex) {
        String errorMessage = ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
