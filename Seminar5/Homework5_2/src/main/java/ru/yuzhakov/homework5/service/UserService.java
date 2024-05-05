package ru.yuzhakov.homework5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yuzhakov.homework5.model.User;
import ru.yuzhakov.homework5.repository.UserRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    public UserRepo userRepository;
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User newUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(newUser.getName());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setPass(newUser.getPass());
            existingUser.setUserRole(newUser.getUserRole());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
