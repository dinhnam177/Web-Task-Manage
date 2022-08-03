package com.example.webtask.mapper;

import com.example.webtask.model.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface TaskMapper {
    Task findByTaskName(@Param("task_name") String taskName);

    void insertTask(@Param("task") Task task);
}
