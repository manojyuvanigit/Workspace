package com.example.QuestionService.controller;

import com.example.QuestionService.model.QuestionWrapper;
import com.example.QuestionService.model.SubmitResponse;
import com.example.QuestionService.model.questions;
import com.example.QuestionService.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;
    @GetMapping("/getQuestions")
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

    @PostMapping("/createQuiz")
    public ResponseEntity<List<Integer>> createQuiz(@RequestParam String category
            , @RequestParam int numberOfQuestions) {
        return questionService.createQuiz(category, numberOfQuestions);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionDetails(@RequestBody List<Integer> questionList){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionDetails(questionList);
    }

    @PostMapping("/calculateScore")
    public ResponseEntity<Integer> calculateScore(@RequestBody List<SubmitResponse> responses){
        return questionService.calculateScore(responses);
    }
}