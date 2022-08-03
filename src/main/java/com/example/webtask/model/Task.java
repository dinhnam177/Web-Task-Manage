package com.example.webtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Task Name is can't not Blank !!!")
    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_status")
    private String taskStatus;

    @NotBlank(message = "Description is can't not Blank !!!")
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userTask;

}
