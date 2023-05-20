package br.com.audsat.carinsurancequotes.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public interface GlobalExceptionHandlerHelper {

    static List<String> buildBeanValidationErrorMessage(final MethodArgumentNotValidException ex) {
        if(ex.getBindingResult().hasFieldErrors()) {
            return ex.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .collect(Collectors.toList());
        } else {
            return ex.getBindingResult()
                    .getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
        }
    }

}
