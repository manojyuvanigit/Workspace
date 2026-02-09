package com.example.Microservices.model;
import java.util.List;

public class QuizResponse {
    String title;

    public String getTitle() {
        return title;
    }

    public List<SubmitResponse> getResponses() {
        return responses;
    }

    List<SubmitResponse> responses;

}
