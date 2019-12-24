package com.example.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Finish extends AppCompatActivity {

    String MBTIResult;
    TextView result;
    Button Home;
    Switch save;
    EditText username;
    String name;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        final SQLiteDatabase sqlite=getBaseContext().openOrCreateDatabase("User_Information", MODE_PRIVATE, null);
        String createTable="CREATE TABLE IF NOT EXISTS userdata(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name TEXT, result TEXT)";
        sqlite.execSQL(createTable);

        MBTIResult=getIntent().getStringExtra("MBTIResult");
        result=(TextView)findViewById(R.id.result);
        save=(Switch)findViewById(R.id.save);
        username=(EditText)findViewById(R.id.username);

        result.setText(MBTIResult);
        showUsernameEditText(username);
        Home=(Button)findViewById(R.id.Home);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name=username.getText().toString();
                String query="INSERT INTO userdata VALUES (null, '"+name+"', '"+MBTIResult+"')";
                sqlite.execSQL(query);
                Log.e("Inserted", "Yes it is Inserted");
                String show;
                Cursor cursor= sqlite.rawQuery("SELECT * FROM userdata", null);
                while(cursor.moveToNext()){
                    String Userid=cursor.getString(0);
                    String Username=cursor.getString(1);
                    String Userresult=cursor.getString(2);
                    Log.e("ID", Userid);
                    Log.e("Username", Username);
                    Log.e("Userresult", Userresult);
                }
                startActivity(new Intent(Finish.this, Home.class));
                finish();
            }
        });
//        Toast.makeText(this, MBTIResult, Toast.LENGTH_SHORT).show();
    }

    public void showUsernameEditText(View view) {
        if(save.isChecked()){
            username.setVisibility(View.VISIBLE);
        }else if(!save.isChecked()){
            username.setVisibility(View.GONE);
        }
    }


}
