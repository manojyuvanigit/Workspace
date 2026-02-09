package com.example.QuestionService.repositories;

import com.example.QuestionService.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<questions, Integer> {
    List<questions> findByCategory(String cat);
    @Query("select q.id from questions q where q.category =:category order by function('RAND') limit :numberOfQuestions")
    List<Integer> findByFilter(String category, int numberOfQuestions);
}
