package com.todoapi.todoapi.services;

import java.util.List;
import java.util.Optional;

import com.todoapi.todoapi.model.Task;
import com.todoapi.todoapi.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    public Task findById(Long id) {
        Optional<Task> obj = taskRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }
    }
}
