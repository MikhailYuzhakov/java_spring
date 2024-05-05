package ru.yuzhakov.demo.service;

import org.springframework.stereotype.Service;
import ru.yuzhakov.demo.model.Task;
import ru.yuzhakov.demo.model.TaskStatus;

import java.util.List;

@Service
public interface TaskService {
    Task addTask(Task task);
    List<Task> getAllTasks();
    List<Task> getTasksByStatus(TaskStatus status);
    Task updateTaskStatus(Long id, TaskStatus status);
    void deleteTask(Long id);
}
