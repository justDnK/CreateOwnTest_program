package com.example.test_programe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test_programe.model.OptionAnswer;
import com.example.test_programe.model.Question;

public interface OptionAnswerRepository extends JpaRepository<OptionAnswer, Long> {
    void deleteAllByQuestionId(Long id);
}
