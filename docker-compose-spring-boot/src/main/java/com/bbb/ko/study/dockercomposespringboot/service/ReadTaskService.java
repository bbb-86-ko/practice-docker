package com.bbb.ko.study.dockercomposespringboot.service;

import com.bbb.ko.study.dockercomposespringboot.entity.Task;
import com.bbb.ko.study.dockercomposespringboot.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadTaskService {

    private final TaskRepository taskRepository;

    public ReadTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> read(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }
}
