    package com.example.test_programe.service;

    import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.test_programe.model.OptionAnswer;
import com.example.test_programe.model.Question;
import com.example.test_programe.model.Test;
    import com.example.test_programe.model.User;
import com.example.test_programe.model.Dto.OptionDto;
import com.example.test_programe.model.Dto.QuestionDto;
import com.example.test_programe.model.Dto.TestDto;
import com.example.test_programe.repository.OptionAnswerRepository;
import com.example.test_programe.repository.QuestionRepository;
import com.example.test_programe.repository.TestRepository;

    @Service 
    public class TestService {
        private final UserService userService;
        private final TestRepository testRepository;
        private final QuestionRepository questionRepository;
        private final OptionAnswerRepository optionAnswerRepository;

        public TestService(
            UserService userService, 
            TestRepository testRepository,
            QuestionRepository questionRepository,
            OptionAnswerRepository optionAnswerRepository
        ) {
            this.userService = userService;
            this.testRepository = testRepository;
            this.questionRepository = questionRepository;
            this.optionAnswerRepository = optionAnswerRepository;
        }

        public void saveNewTest(TestDto newTest, User user) {
            Test test = new Test(newTest.title(), user);
            testRepository.save(test);

            List<QuestionDto> questions = newTest.questions();               
            Test usersTest = testRepository.findByTitle(newTest.title())
                .orElseThrow(() -> new UsernameNotFoundException("error :C"));

            for(var item : questions) {                
                Question newQuestion = new Question(item.text(), usersTest);
                questionRepository.save(newQuestion);

                List<OptionDto> options = item.options();
                Question question = questionRepository.findByText(item.text())
                    .orElseThrow(() -> new UsernameNotFoundException("error :C"));
                for(var jtem : options) {
                    OptionAnswer option = new OptionAnswer(
                        jtem.text(), 
                        jtem.is_correct(), 
                        question);
                    
                    optionAnswerRepository.save(option);
                }
            }

        }

    }
            