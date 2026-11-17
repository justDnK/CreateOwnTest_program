package com.example.test_programe.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test_programe.model.Test;
import com.example.test_programe.model.User;
import com.example.test_programe.model.Dto.TestDto;
import com.example.test_programe.model.Dto.TestDtoTitle;
import com.example.test_programe.service.TestService;
import com.example.test_programe.service.UserService;

@RestController 
public class TestController {
    private final TestService testService;
    private final UserService userService;

    public TestController(
        TestService testService,
        UserService userService
    ) 
    {
        this.testService = testService;
        this.userService = userService;
    }


    @PostMapping("/test/create")
    public void createNewTest(
        @RequestBody TestDto newTest,
        Authentication authentication
    ) {
        User user = userService.findByEmail(authentication.getName());
        testService.saveNewTest(newTest, user);
    }

    @GetMapping("/test/my")
    public List<TestDtoTitle> showAllTestsByUser(
        Authentication authentication
    ) {
        User user = userService.findByEmail(authentication.getName());
        return testService.findTestsByUser(user);
    }

    
}
