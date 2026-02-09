package com.example.QuizService.service;

import com.example.QuizService.feign.QuestionFeignInterface;
import com.example.QuizService.model.*;
import com.example.QuizService.repositories.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionFeignInterface questionFeignInterface;

    public String createQuiz(String title, String category, int numberOfQuestions) {

        quiz newQuiz = new quiz();
        newQuiz.setTitle(title);
        newQuiz.setCategory(category);

        List<Integer> questionsList = questionFeignInterface.createQuiz(category, numberOfQuestions).getBody();

        newQuiz.setQuestions(questionsList);

        quizRepo.save(newQuiz);

        return "Quiz created successfully!";
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
        try{
            Optional<quiz> foundQuiz = quizRepo.findById(id);
            List<QuestionWrapper> questionWrappers = new ArrayList<>();
            if(foundQuiz.isPresent()){
                    List<Integer> questionsList = foundQuiz.get().getQuestions();
                     return questionFeignInterface.getQuestionDetails(questionsList);
            }
            return new ResponseEntity<>(questionWrappers, HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> calculateScore(List<SubmitResponse> response) {
        try{
            return questionFeignInterface.calculateScore(response);
        }catch(Exception e){
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
