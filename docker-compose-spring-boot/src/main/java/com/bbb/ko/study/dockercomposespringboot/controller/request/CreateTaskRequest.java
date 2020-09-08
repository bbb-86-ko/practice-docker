package com.bbb.ko.study.dockercomposespringboot.controller.request;

import lombok.Getter;

@Getter
public class CreateTaskRequest {

    private String text;
    private Long userId;

    public static CreateTaskRequest of(Long userId, String text) {
        CreateTaskRequest request = new CreateTaskRequest();
        request.userId = userId;
        request.text = text;
        return request;
    }
}
