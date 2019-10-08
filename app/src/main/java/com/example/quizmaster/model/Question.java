package com.example.quizmaster.model;

import java.util.List;

public class Question {

    private String question;
    private List<String> selections;
    private String correctSelection;

    public Question(String question, List<String> selections, String correctSelection) {
        this.question = question;
        this.selections = selections;
        this.correctSelection = correctSelection;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getSelections() {
        return selections;
    }

    public void setSelections(List<String> selections) {
        this.selections = selections;
    }

    public String getCorrectSelection() {
        return correctSelection;
    }

    public void setCorrectSelection(String correctSelection) {
        this.correctSelection = correctSelection;
    }
}
