package ru.yuzhakov.homework5.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yuzhakov.homework5.model.Project;
import ru.yuzhakov.homework5.model.User;
import ru.yuzhakov.homework5.model.UsersProject;
import ru.yuzhakov.homework5.service.UserProjectService;
import java.util.List;

@RestController
@RequestMapping("/userproject")
@AllArgsConstructor
public class UserProjectController {

    private UserProjectService service;

    @GetMapping("/getusers/{projectid}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable("projectid") Long projectId) {
        List<User> users = service.getUsersByProjectId(projectId);

        if (users.size() > 0) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getprojects/{userid}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable("userid") Long userId) {
        List<Project> projects = service.getProjectsByUserId(userId);

        if (projects.size() > 0) {
            return ResponseEntity.ok(projects);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUserToProject(@RequestBody UsersProject userToProject) {
        User user = service.addUserToProject(userToProject.getUserId(), userToProject.getProjectId());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/delete/{userid}/{projectid}")
    public ResponseEntity<User> removeUserFromProject(@PathVariable("userid") Long userId,
                                                      @PathVariable("projectid") Long projectId) {
        User deletedUser = service.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok(deletedUser);
    }
}
