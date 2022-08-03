package com.example.webtask.service;

import com.example.webtask.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    List<Task> listAll();
    Task checkExistTask(String taskName);
    void insertTask(Task task);

    Task getTaskById(Integer id);
    void update(Task task);
    int countTask();
    List<Task> findAllByPage(String taskName, String taskStatus, Pageable pageable);

}
