package br.com.audsat.carinsurancequotes.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {
        final List<String> errors = GlobalExceptionHandlerHelper.buildBeanValidationErrorMessage(ex);
        final GlobalExceptionResponse globalExceptionResponse = GlobalExceptionResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .errors(errors)
                .build();
        return new ResponseEntity<>(globalExceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    protected GlobalExceptionResponse handleBusinessException(BusinessException businessException,
                                                              WebRequest request) {
        return GlobalExceptionResponse.builder()
                .error(businessException.getMessage())
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .build();
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected GlobalExceptionResponse handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                      WebRequest request) {
        return GlobalExceptionResponse.builder()
                .error(resourceNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

}
