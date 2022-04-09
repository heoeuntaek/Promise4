package com.example.promise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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





    }
}