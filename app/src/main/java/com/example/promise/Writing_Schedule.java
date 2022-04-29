package com.example.promise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Writing_Schedule extends AppCompatActivity {
    //private boolean State = false;
    boolean bool=false;
    TextView[] tv = new TextView[119];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_schedule);



        for (int i = 1; i <= tv.length; i++) {
            int getID = getResources().getIdentifier("text" + i, "id", "com.example.promise");
            tv[i] = (TextView) findViewById(getID);
        }


        for (int i = 1; i <= tv.length; i++) {
            int finalI = i;
            tv[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(bool)
                    {
                        bool = false;
                        tv[finalI].setBackgroundResource(R.drawable.table_touch_again);
                    }
                    else
                    {
                        bool = true;
                        tv[finalI].setBackgroundResource(R.drawable.table_touch);
                    }
                }
            });
        }
    }
}






