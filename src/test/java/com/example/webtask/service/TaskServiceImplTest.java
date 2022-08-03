package com.example.webtask.service;

import com.example.webtask.model.Task;
import com.example.webtask.repository.TaskRepository;
import com.example.webtask.service.impl.TaskServiceImpl;
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

public class TaskServiceImplTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskServiceImpl;

    List<Task> taskList;

    Page<Task> taskPage;

    @BeforeEach
    void initService(){
        MockitoAnnotations.openMocks(this);
        taskList = new ArrayList<>();
//        taskServiceImpl = new TaskServiceImpl(taskReponsitory);

    }

    @Test
    void testListAll(){
        when(taskRepository.findAll()).thenReturn(taskList);
        assertEquals(taskList, taskServiceImpl.listAll());
    }

    @Test
    void testTaskPaginate(){
//        when(taskService.getTaskPaginate(0,2)).thenReturn(taskPage);
//        assertEquals(taskPage, taskService.getTaskPaginate(0,2));
    }
}
