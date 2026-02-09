package com.example.QuizService.controller;

import com.example.QuizService.model.QuestionWrapper;
import com.example.QuizService.model.QuizDTO;
import com.example.QuizService.model.SubmitResponse;
import com.example.QuizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO) {
            quizService.createQuiz(quizDTO.getTitle(), quizDTO.getCategory(), quizDTO.getNumberOfQuestions());
        return ResponseEntity.ok("Quiz created successfully!");
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
        return quizService.getQuiz(id);
    }

    @PostMapping("/submitAnswers")
    public ResponseEntity<Integer> submitAnswers(@RequestBody List<SubmitResponse> response){
        return quizService.calculateScore(response);
    }

}
