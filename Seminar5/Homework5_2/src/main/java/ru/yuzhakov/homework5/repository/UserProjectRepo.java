package ru.yuzhakov.homework5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yuzhakov.homework5.model.UsersProject;

import java.util.List;

@Repository
public interface UserProjectRepo extends JpaRepository<UsersProject, Long> {

    public void deleteByUserIdAndProjectId(Long userId, Long projectId);

    public List<UsersProject> findByUserId(Long userId);

    public List<UsersProject> findByProjectId(Long projectId);
}
