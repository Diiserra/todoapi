package com.todoapi.todoapi.services;

import java.util.List;
import java.util.Optional;

import com.todoapi.todoapi.model.User;
import com.todoapi.todoapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        List<User> usersList = userRepository.findAll();
        return usersList;
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        if (obj.isPresent()) {
            return obj.get();
        } else {
            return null;
        }

    }

}
