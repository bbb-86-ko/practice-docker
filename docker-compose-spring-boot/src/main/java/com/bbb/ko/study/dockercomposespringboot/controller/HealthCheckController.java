package com.bbb.ko.study.dockercomposespringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    @GetMapping("/health/check")
    public String ping() {
        return "pong";
    }
}
