package ru.yuzhakov.homework4.repository;

import org.springframework.stereotype.Component;
import ru.yuzhakov.homework4.domain.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {}

    public List<User> getAll() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

}
