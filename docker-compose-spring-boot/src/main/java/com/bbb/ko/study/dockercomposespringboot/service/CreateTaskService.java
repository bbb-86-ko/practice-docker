package com.bbb.ko.study.dockercomposespringboot.service;

import com.bbb.ko.study.dockercomposespringboot.entity.Task;
import com.bbb.ko.study.dockercomposespringboot.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService {

    private final TaskRepository taskRepository;

    public CreateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Long userId, String text) {
        return Task.create(taskRepository, userId, text);
    }
}
