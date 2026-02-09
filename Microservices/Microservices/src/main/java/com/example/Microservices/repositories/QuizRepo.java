package com.example.Microservices.repositories;

import com.example.Microservices.model.quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QuizRepo extends JpaRepository<quiz, Integer> {
    Optional<quiz> findByTitle(String title);
}
