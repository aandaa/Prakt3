package lv.annija.pd3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button read = findViewById(R.id.btn_readPref);
        TextView savedPref = findViewById(R.id.txt_preferences);
        SharedPreferences sharedPref = getSharedPreferences("preferences", MODE_PRIVATE);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sharedPref.contains("key")){
                    Toast.makeText(SecondActivity.this, "Nothing found", Toast.LENGTH_LONG).show();
                }
                savedPref.setText(sharedPref.getString("key", ""));

            }
        });
    }
}