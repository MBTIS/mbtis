package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Test extends AppCompatActivity {
    String [] question={
            "At a party do you",
            "Are you more",
            "Is it worse to",
            "Are you more impressed by",
            "Are more drawn toward the",
            "Do you prefer to work",
            "Do you tend to choose",
            "At parties do you",
            "Are you more attracted to",
            "Are you more interested in",
            "In judging others are you more swayed\n" +
                    "by",
            "In approaching others is your inclination\n" +
                    "to be somewhat",
            "Are you more",
            "Does it bother you more having things",
            "In your social groups do you",
            "In doing ordinary things are you more\n" +
                    "likely to",
            "Writers should",
            " Which appeals to you more",
            "Are you more comfortable in making",
            "Do you want things:",
            "Would you say you are more"
    };
     String [][] choice={
            {" Interact with many, including strangers"," Interact with many, including strangers"},
            {" Realistic than speculative", "Speculative than realistic"},
            {"Have your “head in the clouds", "Be “in a rut”"},
            {"Principles", "Emotions"},
            {"Convincing", "Touching"},
            {"To deadlines", "Just “whenever”"},
            {"Rather carefully", "Somewhat impulsively"},
            {"Stay late, with increasing energy", "Leave early with decreased energy"},
            {"Sensible people", "Imaginative people"},
            {"What is actual", " What is possible"},
            {"Laws than circumstances", "Circumstances than laws"},
            {"Objective", "Personal"},
            {"Punctual", "Leisurely"},
            {"Incomplete", "Completed"},
            {" Keep abreast of other’s happenings", "Get behind on the news"},
            {"Do it the usual way", "Do it your own way"},
            {"“Say what they mean and mean what they\n" +
                    "say”", "Express things more by use of analogy"},
            {"Consistency of thought", "Harmonious human relationships"},
            {"Logical judgments", "Value judgments"},
            {"Settled and decided", "Unsettled and undecided"},
             {"Serious and determined", "Easy-going"}

    };

     int [] userAnswer=new int[question.length];

    public TextView questions;
    public RadioButton answerA;
    public RadioButton answerB;
    Button next;
    public RadioGroup buttongroup;
    public int questionNumber;

    public void viewQuestions(){
        questions.setText(Integer.toString(0+1)+". "+question[0]);
        answerA.setText(choice[0][0]);
        answerB.setText(choice[0][1]);
//        if(answerA.isSelected()){
//            userAnswer[0]=1;
//        }else if(answerB.isSelected()){
//            userAnswer[0]=2;
//        }
        if(answerA.isChecked() || answerB.isChecked())
        {
            questionNumber++;
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answerA.isChecked() || answerB.isChecked())
                {
                    if(answerA.isChecked()){
                        userAnswer[questionNumber]=1;
                    }else if(answerB.isChecked()){
                        userAnswer[questionNumber]=2;
                    }
                    questionNumber++;
                }else {
                    Toast.makeText(Test.this, "Please choose an answer", Toast.LENGTH_SHORT).show();
                }

                if(questionNumber<question.length) {
                    questions.setText(Integer.toString(questionNumber+1)+". "+question[questionNumber]);
                    answerA.setText(choice[questionNumber][0]);
                    answerB.setText(choice[questionNumber][1]);
                }else if(questionNumber>=question.length-1){
                    startActivity(new Intent(Test.this,finish.class));
                    finish();
                }
                buttongroup.clearCheck();
                for(int i=0; i<questionNumber; i++) {
                    Log.e("Mesage", Arrays.toString(userAnswer));
                }

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questions=(TextView) findViewById(R.id.questions);
        answerA=(RadioButton) findViewById(R.id.answerA);
        answerB=(RadioButton) findViewById(R.id.answerB);
        next=(Button) findViewById(R.id.next);
        buttongroup=(RadioGroup) findViewById(R.id.answersGroup);
        questionNumber=0;
        viewQuestions();

    }
}
