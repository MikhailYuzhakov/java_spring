package ru.yuzhakov.homework6.model;

import lombok.Data;

import java.util.List;

@Data
public class Characters {
    Info info;
    List<Result> results;
}
