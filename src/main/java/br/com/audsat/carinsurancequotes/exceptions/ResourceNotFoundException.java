package br.com.audsat.carinsurancequotes.exceptions;

/**
 * To be thrown whenever any business entity was not found
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
