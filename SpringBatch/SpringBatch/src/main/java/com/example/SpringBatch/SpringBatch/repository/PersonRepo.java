package com.example.SpringBatch.SpringBatch.repository;

import com.example.SpringBatch.SpringBatch.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Integer> {
}
