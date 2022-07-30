package com.example.webtask.service;

import com.example.webtask.model.Task;
import com.example.webtask.repository.ITaskReponsitory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TaskServiceTest {
    @Mock
    private ITaskReponsitory iTaskReponsitory;

    @InjectMocks
    private TaskService taskService;

    List<Task> taskList;

    Page<Task> taskPage;

    @BeforeEach
    void initService(){
        MockitoAnnotations.openMocks(this);
        taskList = new ArrayList<>();
        taskService = new TaskService(iTaskReponsitory);

    }

    @Test
    void testListAll(){
        when(iTaskReponsitory.findAll()).thenReturn(taskList);
        assertEquals(taskList, taskService.listAll());
    }

    @Test
    void testTaskPaginate(){
//        when(taskService.getTaskPaginate(0,2)).thenReturn(taskPage);
//        assertEquals(taskPage, taskService.getTaskPaginate(0,2));
    }
}
