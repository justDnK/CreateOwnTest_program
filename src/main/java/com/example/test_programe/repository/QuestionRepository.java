package com.example.test_programe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test_programe.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByText(String text);

    List<Question> findAllByTest_Id(Long id);

    void deleteAllByTest_Id(Long id);
}
