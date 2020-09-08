package com.bbb.ko.study.dockercomposespringboot.repository;

import com.bbb.ko.study.dockercomposespringboot.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAllByUserId(Long userId);
}
