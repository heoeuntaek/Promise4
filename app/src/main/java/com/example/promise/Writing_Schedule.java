package com.example.promise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class Writing_Schedule extends AppCompatActivity {
    //private boolean State = false;
    boolean bool[]=new boolean[120];
    TextView[] tv = new TextView[120];
    int color_data[]=new int[120];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_schedule);
        Button btn = (Button) findViewById(R.id.button);
        Arrays.fill(bool,false);


        for (int i = 1; i <= tv.length-1; i++) {
            int getID = getResources().getIdentifier("text" + i, "id", "com.example.promise");
            tv[i] = (TextView) findViewById(getID);
        }


        for (int i = 1; i <= tv.length-1; i++) {
            int finalI = i;
            tv[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(bool[finalI])
                    {
                        bool[finalI] = false;
                        tv[finalI].setBackgroundResource(R.drawable.table_touch_again);
                        color_data[finalI]=0;
                    }
                    else
                    {
                        bool[finalI] = true;
                        tv[finalI].setBackgroundResource(R.drawable.table_touch);
                        color_data[finalI]=1;
                    }
                }
            });
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"저장되었습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}






