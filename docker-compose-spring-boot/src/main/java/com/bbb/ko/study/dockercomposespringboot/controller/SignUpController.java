package com.bbb.ko.study.dockercomposespringboot.controller;

import com.bbb.ko.study.dockercomposespringboot.service.SignUpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class SignUpController {

    private final SignUpService signUpService;


    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping("/create")
    public boolean create(@RequestParam String name, @RequestParam String email) {
        return signUpService.signUp(name, email);
    }
}
