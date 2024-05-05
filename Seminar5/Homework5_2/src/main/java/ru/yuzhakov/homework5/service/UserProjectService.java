package ru.yuzhakov.homework5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yuzhakov.homework5.model.Project;
import ru.yuzhakov.homework5.model.User;
import ru.yuzhakov.homework5.model.UsersProject;
import ru.yuzhakov.homework5.repository.ProjectRepo;
import ru.yuzhakov.homework5.repository.UserProjectRepo;
import ru.yuzhakov.homework5.repository.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserProjectService {
    private UserRepo userRepository;
    private ProjectRepo projectRepository;
    private UserProjectRepo userProjectRepository;

    public List<User> getUsersByProjectId(Long projectId) {
        List<User> users = new ArrayList<>();
        List<UsersProject> usersProjects = userProjectRepository.findByProjectId(projectId);

        for (UsersProject usersProject : usersProjects)
            if (Objects.equals(usersProject.getProjectId(), projectId))
                userRepository.findById(usersProject.getUserId()).ifPresent(users::add);

        return users;
    }

    public List<Project> getProjectsByUserId(Long userId) {
        List<Project> projects = new ArrayList<>();
        List<UsersProject> usersProjects = userProjectRepository.findByUserId(userId);

        for (UsersProject usersProject : usersProjects)
            if (Objects.equals(usersProject.getUserId(), userId))
                projectRepository.findById(usersProject.getProjectId()).ifPresent(projects::add);

        return projects;
    }

    public User addUserToProject(Long userId, Long projectId) {
        User existingUser = userRepository.findById(userId).orElse(null);
        Project existingProject = projectRepository.findById(projectId).orElse(null);

        if (existingProject != null & existingUser != null) {
            UsersProject userProject = new UsersProject(userId, projectId);
            userProjectRepository.save(userProject);
            return existingUser;
        } else {
            return null;
        }
    }

    public User removeUserFromProject(Long userId, Long projectId) {
        User deletedUser = userRepository.findById(userId).orElse(null);
        if (deletedUser != null)
            userProjectRepository.deleteByUserIdAndProjectId(userId, projectId);
        return deletedUser;
    }
}
