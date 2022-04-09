package com.example.promise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Creating_Group extends AppCompatActivity implements View.OnClickListener {

    EditText input1;
    EditText input2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_group);

        input1 = (EditText) findViewById(R.id.Sample1);
        input2 = (EditText) findViewById(R.id.Sample2);

        btn = (Button) findViewById(R.id.create);


        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.create) {
            // 데이터 첨부를하고 액티비티 실행
            String temp1 = input1.getText().toString();
            String temp2 = input2.getText().toString();
            Intent intent01 = new Intent(this, Management_Group.class);
            intent01.putExtra("key01", temp1);
            intent01.putExtra("key02", temp2);
            startActivity(intent01);
        }

    }
}
