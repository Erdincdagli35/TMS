package com.example.task_management_system.service;

import com.example.task_management_system.entity.Task;

import java.util.List;

public interface TaskService {

    Long createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Long updateTask(Task task);

    Long deleteTask(Long id);
}
