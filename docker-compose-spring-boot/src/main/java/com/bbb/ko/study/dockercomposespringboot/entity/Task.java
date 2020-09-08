package com.bbb.ko.study.dockercomposespringboot.entity;

import com.bbb.ko.study.dockercomposespringboot.repository.TaskRepository;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


    public static Task create(TaskRepository taskRepository, Long userId , String text) {
        final LocalDateTime now = LocalDateTime.now();
        Task task = new Task();
        task.userId = userId;
        task.text = text;
        task.createdAt = now;
        task.updatedAt = now;
        return taskRepository.save(task);
    }
}
