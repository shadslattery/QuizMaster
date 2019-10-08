package com.example.quizmaster.viewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.quizmaster.model.Question;
import com.example.quizmaster.repository.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private Repository repo;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repo = Repository.getInstance();

    }

    public List<Question> getQuestions() {
        return repo.getQuestions();
    }

    public Boolean isAnswerCorrect(String answer, String correctAnswer) {
        return answer.equals(correctAnswer);
    }
}
