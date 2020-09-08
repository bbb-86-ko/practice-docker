package com.bbb.ko.study.dockercomposespringboot.controller.response;

import com.bbb.ko.study.dockercomposespringboot.entity.Task;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateTaskResponse {

    private Long id;
    private String text;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CreateTaskResponse of(Task task) {
        CreateTaskResponse response = new CreateTaskResponse();
        response.id = task.getId();
        response.text = task.getText();
        response.userId = task.getUserId();
        response.createdAt = task.getCreatedAt();
        response.updatedAt = task.getUpdatedAt();
        return response;
    }
}
