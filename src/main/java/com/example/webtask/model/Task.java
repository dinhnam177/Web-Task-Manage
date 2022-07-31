package com.example.webtask.model;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_status")
    private String taskStatus;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User userTask;

    public Task() {
    }

    public Task(String taskName, String description) {
        this.taskName = taskName;
        this.description = description;
    }

    public Task(int id, String taskName, String taskStatus) {
        this.id = id;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUserTask() {
        return userTask;
    }

    public void setUserTask(User userTask) {
        this.userTask = userTask;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                '}';
    }
}
