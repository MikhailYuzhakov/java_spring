package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.NotificationService;
import com.example.sem3HomeTask.services.RegistrationService;
import com.example.sem3HomeTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {


    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Создает нового пользователя из POST запроса с телом в формате JSON
     * @param user создаваемый пользователь
     * @return уведомление и том, что пользователь создан
     */
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().save(user);
        return "User added from body!";
    }

    /**
     * Создает нового пользователя c помощью GET запроса с параметрами вида
     * localhost:8080/user/body?name=Mihail&email=exam4@yandex.ru&age=21
     */
    @GetMapping("/body")
    public String userAddFromParam(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        service.getDataProcessingService().getRepository().save(user);
        return "User added from body!";
    }
}
