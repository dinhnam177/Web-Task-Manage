package com.example.webtask.service;

import com.example.webtask.model.Task;
import com.example.webtask.repository.ITaskReponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    private final ITaskReponsitory iTaskReponsitory;

    @Override
    public Page<Task> getTaskPaginate(int currentPage, int page){
        Pageable pageable = PageRequest.of(currentPage,page);
        return iTaskReponsitory.findAll(pageable);
    }

    @Override
    public List<Task> listAll() {
        return iTaskReponsitory.findAll();
    }
}
