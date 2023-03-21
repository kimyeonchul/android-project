package com.example.study03_intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_text;
    private String str;
    ImageView iv_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_text = findViewById(R.id.et_text);


        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = et_text.getText().toString();
                Intent intent = new Intent(MainActivity.this , SubActivity.class);
                intent.putExtra("str",str);
                startActivity(intent); //액티비티 이동해주는 구문

            }
        });

        iv_test = (ImageView) findViewById(R.id.iv_test);
        iv_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"연출이잘생김",Toast.LENGTH_SHORT).show();
            }
        });
    }
}