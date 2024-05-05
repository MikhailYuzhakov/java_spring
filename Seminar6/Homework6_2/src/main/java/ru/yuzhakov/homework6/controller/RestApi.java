package ru.yuzhakov.homework6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yuzhakov.homework6.model.Characters;
import ru.yuzhakov.homework6.service.ServiceApi;

@RestController
@RequestMapping("/characters")
public class RestApi {
    @Autowired
    private ServiceApi service;

    @GetMapping
    public ResponseEntity<Characters> getCharacters() {
        Characters allCharacters = service.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }
}
