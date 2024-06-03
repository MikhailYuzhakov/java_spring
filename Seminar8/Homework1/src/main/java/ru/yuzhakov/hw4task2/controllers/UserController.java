package ru.yuzhakov.hw4task2.controllers;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.yuzhakov.hw4task2.service.UserService;
import ru.yuzhakov.hw4task2.model.User;

import java.util.List;

@Controller
@AllArgsConstructor
@Log
public class UserController {
    private final UserService userService;

    /**
     * Обработывает GET запрос и возвращает страницу со списком пользователей, заполненную шаблонизатором.
     * @param model модель для шаблонизатора
     * @return страницу с пользователями
     */
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        log.info("/users");
        return "user-list";
    }

    /**
     * Возвращает форму для создания нового пользователя.
     * @param user создаваемый пользователь
     * @return форму для создания пользователя
     */
    @GetMapping("/user-create")
    public String createUserForm(User user){
        log.info("/user-create");
        return "user-create";
    }

    /**
     * Обрабатывает POST запрос по нажатию кнокпи создания пользователя. Данные берет из формы с помощью
     * шаблонизатора и заоплняет все поля User.
     * @param user созданный пользователь.
     * @return перенаправляет на GET запрос /users
     */
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        log.info("user created: " + user.toString());
        return "redirect:/users";
    }

    /**
     * Удаляет по GET запросу пользователя согласно его идентификатору.
     * @param id идентификатор пользователя.
     * @return перенаправляет на GET запрос /users
     */
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        log.info("user deleted by id: " + id);
        return "redirect:/users";
    }

    /**
     * Обновляет данные о пользователе по идентификатору.
     * @param id индетификатор пользоватля.
     * @param model модель для шаблонизатора.
     * @return страницу с формой для редактирования пользователя.
     */
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        log.info("call user update method");
        return "user-update";
    }

    /**
     * Обновляет информацию о пользователе по нажатию кнопки.
     * @param user обновленный пользователь
     * @return перенаправляет на GET запрос /users
     */
    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        log.info("user updated: " + user.toString());
        return "redirect:/users";
    }
}
