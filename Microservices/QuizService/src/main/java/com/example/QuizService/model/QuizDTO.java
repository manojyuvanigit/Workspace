package com.example.QuizService.model;

public class QuizDTO {
    String title;
    String category;

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    int numberOfQuestions;
}
