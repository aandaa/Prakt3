package com.agate.repositoryg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    SharedPreferences sharedpreferences;
    //TextView inputText;
    public static final String mypreference = "mypref";
    public static final String Name = "inputTextKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //sharedPreferences
        sharedpreferences = getSharedPreferences("prefID", Context.MODE_PRIVATE);

        String name = sharedpreferences.getString("textKey","No text");

        TextView label = (TextView) findViewById(R.id.nameID);
        label.setText(name);
        //Spinner
        Spinner themes = findViewById(R.id.spinner);
        themes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 0:
                    default:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;
                    case 1:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    case 2:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing here:", Toast.LENGTH_LONG).show();
            }
        });

        Button save= findViewById(R.id.button);
        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView inputText = (TextView) findViewById(R.id.textView);
                EditText nameEditText = (EditText) findViewById(R.id.nameID);
                sharedpreferences = getSharedPreferences("prefID", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("textKey", nameEditText.getText().toString());
                editor.apply();
                inputText.setText("Saved");
            }
        });
        Button goToSecound= findViewById(R.id.button2);
        goToSecound.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent activity2Intent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(activity2Intent);

            }
        });
    }

}