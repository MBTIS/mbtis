package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends AppCompatActivity {
    String [] question={
            "Nobel Mitiku",
            "Yonatan Abera",
            "Kaleabe Seifu"
    };
     String [][] choice={
            {"True","False"},
            {"Yes", "No"},
             {"0", "1"}

    };

     int [] userAnswer;

    public TextView questions;
    public RadioButton answerA;
    public RadioButton answerB;
    public RadioGroup buttongroup;
    public int questionNumber;


    public void nextButton(View view){
        buttongroup.clearCheck();
        if(questionNumber<question.length) {

            questions.setText(Integer.toString(questionNumber+1)+". "+question[questionNumber]);
            answerA.setText(choice[questionNumber][0]);
            answerB.setText(choice[questionNumber][1]);
            Toast.makeText(this, "Question Number "+Integer.toString(questionNumber+1), Toast.LENGTH_SHORT).show();
        }else if(questionNumber>=question.length-1){
            answerA.setText("Error");
            answerB.setText("Error");
        }

        questionNumber++;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questions=(TextView) findViewById(R.id.questions);
        answerA=(RadioButton) findViewById(R.id.answerA);
        answerB=(RadioButton) findViewById(R.id.answerB);
        buttongroup=(RadioGroup) findViewById(R.id.answersGroup);
        questionNumber=0;
        Toast.makeText(this, "Question number 1", Toast.LENGTH_SHORT).show();
        questions.setText(Integer.toString(0+1)+". "+question[0]);
        answerA.setText(choice[0][0]);
        answerB.setText(choice[0][1]);
        questionNumber++;

    }
}
