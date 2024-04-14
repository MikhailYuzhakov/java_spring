package ru.yuzhakov.hw4task2.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yuzhakov.hw4task2.model.User;
import ru.yuzhakov.hw4task2.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public User getUserById(int id) {
        return userRepository.getOne(id);
    }
}
