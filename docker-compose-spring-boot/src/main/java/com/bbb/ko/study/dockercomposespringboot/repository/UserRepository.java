package com.bbb.ko.study.dockercomposespringboot.repository;

import com.bbb.ko.study.dockercomposespringboot.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
