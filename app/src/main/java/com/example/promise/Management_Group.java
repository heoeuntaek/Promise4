package com.example.promise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Management_Group extends AppCompatActivity {

    TextView result_textView1;
    TextView result_textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_group);

        result_textView1= (TextView)findViewById(R.id.text_result1);
        result_textView2= (TextView)findViewById(R.id.text_result2);
        Intent receive_intent = getIntent();
        String temp1 = receive_intent.getStringExtra("key01");
        String temp2 = receive_intent.getStringExtra("key02");
        result_textView1.setText(temp1);
        result_textView2.setText(temp2);
    }
}
