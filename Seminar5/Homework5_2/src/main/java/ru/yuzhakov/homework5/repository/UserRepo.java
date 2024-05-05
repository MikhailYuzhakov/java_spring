package ru.yuzhakov.homework5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yuzhakov.homework5.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
