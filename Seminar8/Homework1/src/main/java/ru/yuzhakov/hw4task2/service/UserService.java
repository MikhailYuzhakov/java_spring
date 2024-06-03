package ru.yuzhakov.hw4task2.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yuzhakov.hw4task2.aspects.TrackUserAction;
import ru.yuzhakov.hw4task2.model.User;
import ru.yuzhakov.hw4task2.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @TrackUserAction
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @TrackUserAction
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @TrackUserAction
    public void updateUser(User user) {
        userRepository.update(user);
    }

    @TrackUserAction
    public User getUserById(int id) {
        return userRepository.getOne(id);
    }
}
