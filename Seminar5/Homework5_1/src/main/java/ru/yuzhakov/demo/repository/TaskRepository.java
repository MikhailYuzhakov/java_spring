package ru.yuzhakov.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yuzhakov.demo.model.Task;
import ru.yuzhakov.demo.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findTaskByStatus(TaskStatus taskStatus);
}
