package com.example.QuizService.feign;

import com.example.QuizService.model.QuestionWrapper;
import com.example.QuizService.model.SubmitResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "QUESTIONSERVICE")
public interface QuestionFeignInterface {
    @PostMapping("/question/createQuiz")
    public ResponseEntity<List<Integer>> createQuiz(@RequestParam String category
            , @RequestParam int numberOfQuestions);

    @PostMapping("/question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionDetails(@RequestBody List<Integer> questionList);

    @PostMapping("/question/calculateScore")
    public ResponseEntity<Integer> calculateScore(@RequestBody List<SubmitResponse> responses);
}
