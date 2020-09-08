package com.bbb.ko.study.dockercomposespringboot.controller;

import com.bbb.ko.study.dockercomposespringboot.controller.request.CreateTaskRequest;
import com.bbb.ko.study.dockercomposespringboot.controller.response.CreateTaskResponse;
import com.bbb.ko.study.dockercomposespringboot.service.CreateTaskService;
import com.bbb.ko.study.dockercomposespringboot.service.ReadTaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final ReadTaskService readTaskService;
    private final CreateTaskService createTaskService;

    public TaskController(ReadTaskService readTaskService, CreateTaskService createTaskService) {
        this.readTaskService = readTaskService;
        this.createTaskService = createTaskService;
    }

    @GetMapping("/read")
    public List<CreateTaskResponse> read(@RequestParam Long userId) {
        return readTaskService.read(userId)
                .stream()
                .map(CreateTaskResponse::of)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public CreateTaskResponse create(@RequestBody CreateTaskRequest request) {
        var task = createTaskService.createTask(request.getUserId(), request.getText());
        return CreateTaskResponse.of(task);
    }
}
