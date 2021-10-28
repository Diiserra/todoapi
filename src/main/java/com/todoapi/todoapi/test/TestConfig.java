package com.todoapi.todoapi.test;

import java.util.Date;
import java.util.List;

import com.todoapi.todoapi.model.Task;
import com.todoapi.todoapi.model.User;
import com.todoapi.todoapi.repository.TaskRepository;
import com.todoapi.todoapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Diego", "serra@", "1234");
        User u2 = new User(null, "Serra", "diiserra@", "321");
        User u3 = new User(null, "Serra", "diisea@", "321");

        Task t1 = new Task(null, "asdsfafa", null, "S", u1);
        Task t2 = new Task(null, "asdfasfafa", new Date(), "N", u2);
        Task t3 = new Task(null, "asdfasfafa", new Date(), "S", u1);

        userRepository.saveAll(List.of(u1, u2, u3));
        taskRepository.saveAll(List.of(t1, t2, t3));

    }

}
