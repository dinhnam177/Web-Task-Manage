package com.example.webtask.mapper;

import com.example.webtask.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface TaskMapper {
    Task findByTaskName(@Param("task_name") String taskName);

    void insertTask(@Param("task") Task task);

    void updateTask(@Param("task") Task task);

    int countTasks();
    List<Task> findAllByPage(@Param("taskName") String taskName,
                             @Param("taskStatus") String taskStatus,
                             @Param("pageable") Pageable pageable);
}
