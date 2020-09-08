package com.bbb.ko.study.dockercomposespringboot.entity;

import com.bbb.ko.study.dockercomposespringboot.repository.UserRepository;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public static User create(UserRepository userRepository, String name, String email) {
        final LocalDateTime now = LocalDateTime.now();
        User user = new User();
        user.name = name;
        user.email = email;
        user.createdAt = now;
        user.updatedAt = now;
        return userRepository.save(user);
    }
}
