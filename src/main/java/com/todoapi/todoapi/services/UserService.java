package com.todoapi.todoapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.todoapi.todoapi.exception.ResourceNotFoundException;
import com.todoapi.todoapi.model.User;
import com.todoapi.todoapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User findByEmail(String email) {
        Optional<User> optUser = userRepository.findByEmail(email);
        return optUser.orElseThrow(() -> new ResourceNotFoundException(email));

    }

    public User saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean validUser(String email, String password) {
        User user = findByEmail(email);
        return encoder.matches(password, user.getPassword());
    }

    public void deleteUser(String email) {
        User user = findByEmail(email);
        try {
            userRepository.deleteById(user.getId());
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(email);
        }
    }

    public User updateUser(Long id, User obj) {
        try {
            User entity = userRepository.getOne(id);
            updateData(entity, obj);
            entity = userRepository.save(entity);
            return entity;
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
    }

}
