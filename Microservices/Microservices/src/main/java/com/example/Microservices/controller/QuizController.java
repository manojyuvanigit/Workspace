package com.example.Microservices.controller;

import com.example.Microservices.model.QuestionWrapper;
import com.example.Microservices.model.QuizResponse;
import com.example.Microservices.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz/admin")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String title, @RequestParam String category
    , @RequestParam int numberOfQuestions) {
            quizService.createQuiz(title, category, numberOfQuestions);
        return ResponseEntity.ok("Quiz created successfully!");
    }

    @GetMapping("/getQuiz/{title}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable String title){
        return quizService.getQuiz(title);
    }

    @PostMapping("/submitAnswers")
    public ResponseEntity<Integer> submitAnswers(@RequestBody QuizResponse response){
        return quizService.calculateScore(response);
    }

}
