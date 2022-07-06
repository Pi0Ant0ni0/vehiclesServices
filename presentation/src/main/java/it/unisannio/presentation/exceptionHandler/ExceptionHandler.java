package it.unisannio.presentation.exceptionHandler;

import it.unisannio.domain.exceptions.LicensePlateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(LicensePlateException.class)
    public ResponseEntity<Object> handleCityNotFoundException(LicensePlateException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
