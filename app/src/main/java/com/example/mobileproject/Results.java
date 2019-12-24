package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    TextView ShowResults;
    EditText ResultsUsername;
    Button Search;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ShowResults=(TextView)findViewById(R.id.DisplayResult);
        ResultsUsername=(EditText) findViewById(R.id.resultUsername);
        Search=(Button) findViewById(R.id.display);
    }

    public void search(View view) {
        if(ResultsUsername.length() != 0){
            retriveData();
        }
        else {
            Toast.makeText(this, "Please Fill your name!", Toast.LENGTH_SHORT).show();
        }
    }
    public void retriveData(){
                SQLiteDatabase sqlite=getBaseContext().openOrCreateDatabase("User_Information", MODE_PRIVATE, null);
                name=ResultsUsername.getText().toString();
                Cursor cursor= sqlite.rawQuery("SELECT * FROM userdata where name='"+name+"'", null);
                while(cursor.moveToNext()){
                    String Userid=cursor.getString(0);
                    String Username=cursor.getString(1);
                    String Userresult=cursor.getString(2);
                    ShowResults.setText("Hey "+Username+" your MBTI Result is \n"+Userresult);
                }
        }
}
