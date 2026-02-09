package com.example.QuestionService.service;

import com.example.QuestionService.model.QuestionWrapper;
import com.example.QuestionService.model.SubmitResponse;
import com.example.QuestionService.model.questions;
import com.example.QuestionService.repositories.QuestionsRepo;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionsRepo questionsRepo;

    public ResponseEntity<List<questions>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionsRepo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.valueOf(e.getMessage()));
        }
    }

    public ResponseEntity<List<questions>> getAllQuestions(String cat) {
        try{
            return new ResponseEntity<>( questionsRepo.findByCategory(cat), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.valueOf(e.getMessage()));
        }
    }

    public ResponseEntity<String> addQuestion(questions ques) {
        questionsRepo.save(ques);
        return new ResponseEntity<>("Question successfully added", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> createQuiz(String category, int numberOfQuestions) {
        List<Integer> questionsList = questionsRepo.findByFilter(category, numberOfQuestions);
        return new ResponseEntity<>(questionsList,HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionDetails(List<Integer> questionList) {
        List<QuestionWrapper> questionWrappers = new ArrayList<>();
        for(Integer id : questionList) {
            questions ques = questionsRepo.findById(id).orElse(null);
            if (ques != null) {
                QuestionWrapper qw = new QuestionWrapper();
                qw.setId(ques.getId());
                qw.setCategory(ques.getCategory());
                qw.setDifficulty_level(ques.getDifficulty_level());
                qw.setQuestion(ques.getQuestion());
                qw.setOption1(ques.getOption1());
                qw.setOption2(ques.getOption2());
                qw.setOption3(ques.getOption3());
                questionWrappers.add(qw);
            }
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(List<SubmitResponse> responses) {
        int score = 0;
        for(SubmitResponse ans : responses){
            questions ques = questionsRepo.findById(ans.getQuestionId()).orElse(null);
            if(ques != null && ques.getRightAnswer().equals(ans.getSubmittedAnswer())){
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
