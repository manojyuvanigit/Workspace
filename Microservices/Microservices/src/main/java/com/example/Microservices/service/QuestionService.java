package com.example.Microservices.service;

import com.example.Microservices.model.questions;
import com.example.Microservices.repositories.QuestionsRepo;
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
}
