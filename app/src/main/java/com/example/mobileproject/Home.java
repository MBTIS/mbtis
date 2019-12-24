package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    public void mbtiDetail(View view) {
        startActivity(new Intent(Home.this, MbtiDetail.class));
    }

    public void help(View view) {
        startActivity(new Intent(Home.this, Help.class));
    }

    public void about(View view) {
        startActivity(new Intent(Home.this, About.class));
    }

    public void results(View view) {
        startActivity(new Intent(Home.this, Results.class));
    }
    public void test(View view) {
        finish();
        startActivity(new Intent(Home.this, Test.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

}
