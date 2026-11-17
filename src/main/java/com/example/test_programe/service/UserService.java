package com.example.test_programe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.test_programe.model.User;
import com.example.test_programe.repository.UserRepository;

@Service 
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("error :c"));
    }

    public void saveUser(User user) {
       userRepository.save(user);
    }
}

/*
структура таблиц

users           (id, name, email, password, role)
tests           (id, user_id → users.id, title)
questions       (id, test_id → tests.id, text)
answer_options  (id, question_id → questions.id, text, is_correct)
*/
