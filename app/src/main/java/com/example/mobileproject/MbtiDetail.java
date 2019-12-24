package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MbtiDetail extends AppCompatActivity {
TextView MbtiTestDetail;
String detail="The Myers–Briggs Type Indicator (MBTI) is an introspective self-report questionnaire indicating differing psychological preferences in how people perceive the world and make decisions. \n\n\n\n" +
        "The original versions of the MBTI were constructed by two Americans, Katharine Cook Briggs and her daughter Isabel Briggs Myers. The MBTI is based on the conceptual theory proposed by Swiss psychiatrist Carl Jung, who had speculated that people experience the world using four principal psychological functions – sensation, intuition, feeling, and thinking – and that one of these four functions is dominant for a person most of the time. The four categories are Introversion/Extraversion, Sensing/Intuition, Thinking/Feeling, Judging/Perception. Each person is said to have one preferred quality from each category, producing 16 unique types. The Center for Applications of Psychological Type states that the MBTI is scientifically supported, but most of the research on it is done through its own journal, the Journal of Psychological Type, raising questions of bias.\n\n\n\n" +
        "The MBTI was constructed for normal populations and emphasizes the value of naturally occurring differences. \"The underlying assumption of the MBTI is that we all have specific preferences in the way we construe our experiences, and these preferences underlie our interests, needs, values, and motivation.\"\n\n\n" +
        "The MBTI is designed to help people gain insights about themselves and how they interact with others and improve how they communicate, learn, and work (and not for selection such as hiring or placement).\n" +
        "The test measures four key areas:\n" +
        "1. Directing and receiving energy\n" +
        "2. Taking in information\n" +
        "3. Making decisions\n" +
        "4. Approaching the outside world\n" +
        "These areas are sorted into 16 personality types.\n\n\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti_detail);
        MbtiTestDetail=(TextView)findViewById(R.id.MbtiDetailText);
        MbtiTestDetail.setText(detail);
    }
}
