package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Finish extends AppCompatActivity {

    String MBTIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        MBTIResult=getIntent().getStringExtra("MBTIResult");
        Toast.makeText(this, MBTIResult, Toast.LENGTH_SHORT).show();
    }
}
