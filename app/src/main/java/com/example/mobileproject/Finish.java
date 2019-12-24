package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Finish extends AppCompatActivity {

    String MBTIResult;
    TextView result;
    Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        MBTIResult=getIntent().getStringExtra("MBTIResult");
        result=(TextView)findViewById(R.id.result);
        result.setText(MBTIResult);
        Home=(Button)findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Finish.this, Home.class));
                finish();
            }
        });
//        Toast.makeText(this, MBTIResult, Toast.LENGTH_SHORT).show();
    }
}
