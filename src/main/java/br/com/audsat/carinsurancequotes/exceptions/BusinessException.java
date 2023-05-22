package br.com.audsat.carinsurancequotes.exceptions;

/**
 * To be thrown whenever a business rule is violated
 */
public class BusinessException extends RuntimeException {

    public BusinessException(final String message) {
        super(message);
    }
}
