package com.bbb.ko.study.dockercomposespringboot.service;

import com.bbb.ko.study.dockercomposespringboot.entity.User;
import com.bbb.ko.study.dockercomposespringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpService {

    private final UserRepository userRepository;

    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean signUp(String name, String email) {
        var user = User.create(userRepository, name, email);
        return Optional.ofNullable(user)
                .isPresent();
    }
}
