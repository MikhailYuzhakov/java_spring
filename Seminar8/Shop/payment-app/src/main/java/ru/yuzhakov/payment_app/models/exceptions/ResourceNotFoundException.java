package ru.yuzhakov.payment_app.models.exceptions;

/**
 * Товар не найден.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
