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
    int E=0, I=0, S=0, N=0, T=0, F=0, J=0, P=0;
    String Result[]=new String [4];
    String MBTIResult;
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
            {" Interact with many, including strangers"," Interact with a few, known to you"},
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
                    computeMBTIResult();
//                    startActivity(new Intent(Test.this,Finish.class));
                    Intent intent=new Intent(Test.this, Finish.class);
                    intent.putExtra("MBTIResult", computeMBTIResult());
                    startActivity(intent);
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

    public String computeMBTIResult(){

        for (int i=0; i<userAnswer.length; i++){

            if(i%7==0){
                if(userAnswer[i]==1){
                    E++;
                }else{
                    I++;
                }
            }else if(i%7==1 || i%7==2){
                if(userAnswer[i]==1){
                    S++;
                }else{
                    N++;
                }
            }else if(i%7==3 || i%7==4){
                if(userAnswer[i]==1){
                    T++;
                }else{
                    F++;
                }
            }else if(i%7==5 || i%7==6){
                if(userAnswer[i]==1){
                    J++;
                }else{
                    P++;
                }
            }
        }

        if(E>I){
            Result[0]="E";
        }else{
            Result[0]="I";
        }
        if(S>N){
            Result[1]="S";
        }else{
            Result[1]="N";
        }
        if(T>F){
            Result[2]="T";
        }else{
            Result[2]="F";
        }
        if(J>P){
            Result[3]="J";
        }else{
            Result[3]="P";
        }

        MBTIResult=Arrays.toString(Result);


        Log.e("MBTI Result is ", MBTIResult);
        return MBTIResult;
    }
}
