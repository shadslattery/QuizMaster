package com.example.quizmaster.repository;

import com.example.quizmaster.model.Question;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private Repository() {
    }

    private static class InstanceHolder {
        private static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(getQuestion());
        return questions;
    }

    private Question getQuestion() {
        String question = "What is Oxygen?";
        String correctAnswer = "O2";

        List<String> selections = new ArrayList<>();
        selections.add("H");
        selections.add("H2O");
        selections.add(correctAnswer);
        selections.add("C");

        return new Question(question, selections, correctAnswer);
    }
}
