package lv.anda.pd3;

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
        Button backButton = (Button) this.findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button readButton = (Button) this.findViewById(R.id.btn_pref);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.textView);
                SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
                String value = sharedPreferences.getString("new_v",null);
                if(value==null){
                    Toast.makeText(SecondActivity.this, "Nothing found!", Toast.LENGTH_SHORT).show();
                }else{

                    textView.setText(value);
                }
            }
        });
    }
}