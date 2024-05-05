package ru.yuzhakov.homework5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yuzhakov.homework5.model.Project;
import ru.yuzhakov.homework5.repository.ProjectRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepo projectRepository;

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project updateProject(Long id, Project newProject) {
        Project existingProject = projectRepository.findById(id).orElse(null);
        if (existingProject != null) {
            existingProject.setName(newProject.getName());
            existingProject.setDescription(newProject.getDescription());
            existingProject.setCreatedDate(newProject.getCreatedDate());
            return projectRepository.save(existingProject);
        } else  {
            return null;
        }
    }

    public Project findProject(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
