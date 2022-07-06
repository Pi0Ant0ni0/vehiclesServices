package it.unisannio.domain.exceptions;

public class LicensePlateException extends RuntimeException {
    public LicensePlateException(String error) {
        super(error);
    }
}
