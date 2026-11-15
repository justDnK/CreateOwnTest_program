package com.example.test_programe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test_programe.model.OptionAnswer;

public interface OptionAnswerRepository extends JpaRepository<OptionAnswer, Long> {
    
}
