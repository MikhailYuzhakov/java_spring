package ru.yuzhakov.product_storage.models.exceptions;

/**
 * Превышение остатка товара на складе.
 */
public class ExcessAmountException extends RuntimeException{
    public ExcessAmountException(String message) {
        super(message);
    }
}
