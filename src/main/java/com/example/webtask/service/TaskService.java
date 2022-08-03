package com.example.webtask.service;

import com.example.webtask.model.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    List<Task> listAll();
    Task checkExistTask(String taskName);
    void insertTask(Task task);

    Task get(Integer id);
    void update(Task task);
    Page<Task> getTaskPaginate(String taskName, String taskStatus, Pageable pageable);

}
