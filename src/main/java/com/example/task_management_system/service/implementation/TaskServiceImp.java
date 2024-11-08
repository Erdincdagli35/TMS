package com.example.task_management_system.service.implementation;

import com.example.task_management_system.entity.Task;
import com.example.task_management_system.service.TaskService;
import com.example.task_management_system.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Long createTask(Task task) {
        taskRepository.save(task);
        return task.getId();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findOneById(id);
    }

    @Override
    public Long updateTask(Task task) {
        Task taskFromDB = getTaskById(task.getId());

        taskFromDB.setCompleted(task.isCompleted());
        taskFromDB.setTitle(task.getTitle());
        taskFromDB.setDescription(task.getDescription());

        taskRepository.save(taskFromDB);
        return taskFromDB.getId();
    }

    @Override
    public Long deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
        return task.getId();
    }
}
