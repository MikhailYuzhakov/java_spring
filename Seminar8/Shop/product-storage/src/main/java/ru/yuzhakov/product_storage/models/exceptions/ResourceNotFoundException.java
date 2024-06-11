package ru.yuzhakov.product_storage.models.exceptions;

/**
 * Товар не найден.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
