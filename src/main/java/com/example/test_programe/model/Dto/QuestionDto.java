package com.example.test_programe.model.Dto;

import java.util.List;

public record QuestionDto(String text, List<OptionDto> options) {}
