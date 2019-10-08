package com.example.quizmaster.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.example.quizmaster.R;
import com.example.quizmaster.model.Question;
import com.example.quizmaster.viewmodel.MainViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare variables
    private MaterialCardView cardView;
    private TextView tvQuestion;
    private MaterialButton btnChoice1, btnChoice2, btnChoice3, btnChoice4;
    private MainViewModel viewModel;
    private String correctAnswer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        cardView = findViewById(R.id.cv_question_holder);
        tvQuestion = findViewById(R.id.tv_question_text);
        btnChoice1 = findViewById(R.id.btn_choice_one);
        btnChoice2 = findViewById(R.id.btn_choice_two);
        btnChoice3 = findViewById(R.id.btn_choice_three);
        btnChoice4 = findViewById(R.id.btn_choice_four);

        btnChoice1.setOnClickListener(this);
        btnChoice2.setOnClickListener(this);
        btnChoice3.setOnClickListener(this);
        btnChoice4.setOnClickListener(this);

        // Initialize viewmodel
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // Get first question from MainViewModel
        Question firstQuestion = viewModel.getQuestions().get(0);
        // Load first question
        loadQuestion(firstQuestion);
    }

    /**
     * This method will load a Question object to the view
     * @param currentQuestion This object will be used to get the values to be loaded
     */
    private void loadQuestion(Question currentQuestion) {
        // get the correct question from the Question object
        correctAnswer = currentQuestion.getCorrectSelection();

        // get the question to be loaded from the Question object in the question property
        String question = currentQuestion.getQuestion();
        tvQuestion.setText(question);

        // get the answer selections to be loaded from the Question object in the selections property
        String choice1 = currentQuestion.getSelections().get(0);
        String choice2 = currentQuestion.getSelections().get(1);
        String choice3 = currentQuestion.getSelections().get(2);
        String choice4 = currentQuestion.getSelections().get(3);

        btnChoice1.setText(choice1);
        btnChoice2.setText(choice2);
        btnChoice3.setText(choice3);
        btnChoice4.setText(choice4);
    }

    @Override
    public void onClick(View view) {

        String selectedChoice;
        switch (view.getId()) {
            case R.id.btn_choice_one:
                selectedChoice = btnChoice1.getText().toString();
                answerSelected(selectedChoice);
                break;
            case R.id.btn_choice_two:
                selectedChoice = btnChoice2.getText().toString();
                answerSelected(selectedChoice);
                break;
            case R.id.btn_choice_three:
                selectedChoice = btnChoice3.getText().toString();
                answerSelected(selectedChoice);
                break;
            case R.id.btn_choice_four:
                selectedChoice = btnChoice4.getText().toString();
                answerSelected(selectedChoice);
                break;
        }
    }

    private void answerSelected(String answer) {
        // pass selected and correct answer to viewmodel,
        // viewmodel will tell us if it is indeed a correct answer
        boolean isCorrectAnswer = viewModel.isAnswerCorrect(answer, correctAnswer);

        // If statement to show user if they were right or wrong
        if (isCorrectAnswer) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            // Get color from color.xml
            int green = ContextCompat.getColor(this, R.color.green);
            cardView.setCardBackgroundColor(green);
        } else {
            Toast.makeText(this, "InCorrect", Toast.LENGTH_SHORT).show();
            // Get color from color.xml
            int red = ContextCompat.getColor(this, R.color.red);
            cardView.setCardBackgroundColor(red);
        }
    }
}
