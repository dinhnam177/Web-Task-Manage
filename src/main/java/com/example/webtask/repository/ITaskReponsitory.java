package com.example.webtask.repository;

import com.example.webtask.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskReponsitory extends JpaRepository<Task, String> {
    Task findByTaskName(String taskName);
    Page<Task> findAllByTaskNameContainingAndTaskStatusContaining(String taskName, String taskStatus, Pageable pageable);

}
