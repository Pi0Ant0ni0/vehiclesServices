package it.unisannio.domain.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String error) {
        super(error);
    }
}
