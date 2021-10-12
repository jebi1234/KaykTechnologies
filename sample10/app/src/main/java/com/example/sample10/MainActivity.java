package com.example.sample10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button btn;
    private TextView display;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.clickme);
        display = findViewById(R.id.display);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;

            }
        });
        //display.setText(integer.toString(num));
        display.setText(String.valueOf(num));
    }
}