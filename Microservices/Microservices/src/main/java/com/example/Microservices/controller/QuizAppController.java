package com.example.Microservices.controller;

import com.example.Microservices.model.questions;
import com.example.Microservices.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizAppController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/questions")
    public ResponseEntity<List<questions>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping("/addQuestions")
    public ResponseEntity<String> addQuestion(@RequestBody  questions ques){
        return questionService.addQuestion(ques);

    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<questions>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestions(category);
    }
}