package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Метод создает нового пользователя, добавляет его в репозиторий и отправляет уведомление о создании в коносоль.
     * @param name имя пользователя
     * @param email адрес электронной почты пользователя
     * @param age возраст пользоватля
     */
    public void processRegistration(String name, String email, int age) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("Создан новый пользователь!");
    }
}
