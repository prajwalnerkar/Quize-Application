package com.example.quizeapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private RadioGroup answerOptionsRadioGroup;
    private RadioButton option1RadioButton;
    private RadioButton option2RadioButton;
    private RadioButton option3RadioButton;
    private RadioButton option4RadioButton;
    private Button nextButton;

    private String[] questions = {
            "What is the capital of Japan?",
            "Which planet is known as the \"Red Planet\"?",
            "Who painted the Mona Lisa?",
            "What is the largest mammal on Earth?"
    };

    private String[][] options = {
            {"Tokyo", "Beijing", "Seoul", "Bangkok"},
            {"Mars", "Venus", "Jupiter", "Saturn"},
            {"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Michelangelo"},
            {"Blue Whale", "African Elephant", "Giraffe", "Polar Bear"}
    };

    private int[] correctAnswers = {0, 0, 0, 0}; // Indices of correct options

    private int currentQuestionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        questionTextView = findViewById(R.id.questionTextView);
        answerOptionsRadioGroup = findViewById(R.id.answerOptionsRadioGroup);
        option1RadioButton = findViewById(R.id.option1RadioButton);
        option2RadioButton = findViewById(R.id.option2RadioButton);
        option3RadioButton = findViewById(R.id.option3RadioButton);
        option4RadioButton = findViewById(R.id.option4RadioButton);
        nextButton = findViewById(R.id.nextButton);

        loadQuestion(currentQuestionIndex);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion(currentQuestionIndex);
                } else {
                    // Display quiz result or handle end of quiz
                }
            }
        });
    }

    private void loadQuestion(int questionIndex) {
        questionTextView.setText(questions[questionIndex]);
        option1RadioButton.setText(options[questionIndex][0]);
        option2RadioButton.setText(options[questionIndex][1]);
        option3RadioButton.setText(options[questionIndex][2]);
        option4RadioButton.setText(options[questionIndex][3]);
        answerOptionsRadioGroup.clearCheck();
    }

    private void checkAnswer() {
        int selectedOptionId = answerOptionsRadioGroup.getCheckedRadioButtonId();
        if (selectedOptionId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedOptionId);
            int selectedOptionIndex = answerOptionsRadioGroup.indexOfChild(selectedRadioButton);
            if (selectedOptionIndex == correctAnswers[currentQuestionIndex]) {

            } else {

            }
        }
    }
}
