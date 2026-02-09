package com.example.Microservices.service;

import com.example.Microservices.model.*;
import com.example.Microservices.repositories.QuestionsRepo;
import com.example.Microservices.repositories.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    QuestionsRepo questionsRepo;
    public String createQuiz(String title, String category, int numberOfQuestions) {

        quiz newQuiz = new quiz();
        newQuiz.setTitle(title);
        newQuiz.setCategory(category);

        List<questions> questionsList = questionsRepo.findByFilter(category, numberOfQuestions);

        newQuiz.setQuestions(questionsList);

        quizRepo.save(newQuiz);

        return "Quiz created successfully!";
    }

    public ResponseEntity<List<QuestionWrapper>>    getQuiz(String title) {
        try{
            Optional<quiz> foundQuiz = quizRepo.findByTitle(title);
            List<questions> questionsList = null;
            List<QuestionWrapper> questionWrappers = new ArrayList<>();
            if(foundQuiz.isPresent()){
                 questionsList = foundQuiz.get().getQuestions();
                for(questions q : questionsList){
                    QuestionWrapper qw = new QuestionWrapper();
                    qw.setId(q.getId());
                    qw.setCategory(q.getCategory());
                    qw.setDifficulty_level(q.getDifficulty_level());
                    qw.setQuestion(q.getQuestion());
                    questionWrappers.add(qw);
                }
            }
            return new ResponseEntity<>(questionWrappers, HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Integer> calculateScore(QuizResponse response) {
        try{
            String title = response.getTitle();
            List<SubmitResponse> answers = response.getResponses();
            int result = 0;
            Optional<quiz> foundQuiz = quizRepo.findByTitle(title);
            if(foundQuiz.isPresent()){
                System.out.println("Quiz found");
               List<questions> questionsList = foundQuiz.get().getQuestions();
               for(SubmitResponse ans : answers){
                   for(questions q : questionsList){
                       if(q.getId() == ans.getQuestionId()){
                           if(q.getRightAnswer().equals(ans.getSubmittedAnswer())){
                               result ++;
                           }
                       }
                   }
               }
            }

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
