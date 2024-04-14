package ru.yuzhakov.homework4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.yuzhakov.homework4.domain.User;
import ru.yuzhakov.homework4.repository.UserRepository;

import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    /**
     * Получает всех пользователей их репозитория и добавляет данные о их полях в модель шаблонизатора.
     * @param model модель шаблонизатора.
     * @return страницу с данными о пользователе.
     */
    @GetMapping("/users")
    public String getUserpage(Model model) {
        List<User> userList = userRepository.getAll();
        User user = userList.get(0);
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());
        return "userpage";
    }

    /**
     * Метод обрабатывает GET запрос от клиента и возвращает форму для заполнения данными.
     * @param user передаем, потому что в форме через шаблонизатор есть User.
     * @return страницу с рег. формой.
     */
    @GetMapping("/reg")
    public String createRegistrationForm(User user) {
        return "reg";
    }

    /**
     * Обрабатывает по нажатию кнопки POST запрос с данными о пользователе.
     * @param user создаваемый объект.
     * @return перенаправляет на страницу пользователя.
     */
    @PostMapping("/reg")
    public String createUser(User user) {
        userRepository.addUser(user);
        return "redirect:/users";
    }
}
