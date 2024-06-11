package ru.yuzhakov.product_storage.models.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionBody {
    private String message;
    private LocalDateTime dateTime;
}
