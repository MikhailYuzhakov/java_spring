package ru.yuzhakov.homework4.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/home")
    public String startPage() {
        return "index.html";
    }

    @RequestMapping("/data")
    public String dataPage(Model model) {
        String name = "Южаков";
        Integer age = 26;
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "index.html";
    }
}
