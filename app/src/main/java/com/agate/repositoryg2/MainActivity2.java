package com.agate.repositoryg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String somethingElse = "Nothing found";
        Button read= findViewById(R.id.button3);
        read.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView newText= (TextView) findViewById(R.id.textView2);
                SharedPreferences readText = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                String value = readText.getString("textKey", "No text");
                if(value==""){
                    newText.setText(somethingElse);
                }else {newText.setText(value);}
            }
        });
        Button goBack= findViewById(R.id.button4);
        goBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent activity2Intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(activity2Intent);
                finish();
            }
        });
    }
}