package com.example.promise;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    TextView user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create_group_btn = (Button) findViewById(R.id.button1);
        create_group_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Creating_Group.class);
                startActivity(intent);
            }
        });

        Button participate_group_btn = (Button) findViewById(R.id.button2);
        participate_group_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Participating_Group.class);
                startActivity(intent);
            }
        });

        Button management_group_btn = (Button) findViewById(R.id.button3);
        management_group_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Management_Group.class);
                startActivity(intent);
            }
        });

        Button management_schedule_btn = (Button) findViewById(R.id.button4);
        management_schedule_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Management_Schedule.class);
                startActivity(intent);
            }
        });

        user_id = (TextView) findViewById(R.id.user_id);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String userId = sharedPref.getString("user_id", "");
        user_id.setText(userId+"님 환영합니다.");


    }
}