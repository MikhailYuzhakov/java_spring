package ru.yuzhakov.homework6.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yuzhakov.homework6.model.Characters;
import ru.yuzhakov.homework6.model.Result;
import ru.yuzhakov.homework6.service.ServiceApiImlp;

import java.util.List;

@Controller
@AllArgsConstructor
public class ControllerAPI {
    private ServiceApiImlp service;

    @GetMapping
    public String findAll(Model model) {
        Characters characters = service.getAllCharacters();
        List<Result> results = characters.getResults();
        model.addAttribute("results", results);

        return "index";
    }
}
