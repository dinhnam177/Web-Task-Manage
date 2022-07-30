package com.example.webtask.service;

import com.example.webtask.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITaskService {
    List<Task> listAll();
    Page<Task> getTaskPaginate(String taskName, String taskStatus, Pageable pageable);

}