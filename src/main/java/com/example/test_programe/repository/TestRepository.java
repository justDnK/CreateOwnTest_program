package com.example.test_programe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test_programe.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findByTitleAndUserId(String title, Long id);
}
