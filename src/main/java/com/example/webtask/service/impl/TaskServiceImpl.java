package com.example.webtask.service.impl;

import com.example.webtask.mapper.TaskMapper;
import com.example.webtask.model.entity.Task;
import com.example.webtask.repository.TaskRepository;
import com.example.webtask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Override
    public Page<Task> getTaskPaginate(String taskName, String taskStatus, Pageable pageable) {
        return taskRepository.findAllByTaskNameContainingAndTaskStatusContaining(taskName, taskStatus, pageable);
    }

    @Override
    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task checkExistTask(String taskName) {
        return taskMapper.findByTaskName(taskName);
    }

    @Override
    public void insertTask(Task task) {
        task.setTaskStatus("open");
        taskMapper.insertTask(task);
    }

    @Override
    public Task get(Integer id) {
        Optional<Task> result = taskRepository.findAllById(id);
        if (result.isPresent()){
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public void update(Task task) {

    }

}
