package com.example.webtask.repository;

import com.example.webtask.model.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    Task findByTaskName(String taskName);
    Page<Task> findAllByTaskNameContainingAndTaskStatusContaining(String taskName, String taskStatus, Pageable pageable);
    Optional<Task> findAllById(Integer id);
}
