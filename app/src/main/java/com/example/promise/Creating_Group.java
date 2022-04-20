package com.example.promise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Creating_Group extends AppCompatActivity implements View.OnClickListener {

    EditText input1;
    EditText input2;
    Button btn;

    EditText user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_group);

        input1 = (EditText) findViewById(R.id.group_name);
        input2 = (EditText) findViewById(R.id.group_user_name_createGroup);

        btn = (Button) findViewById(R.id.create);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl("http://3.34.97.79:8080/")
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
//                Call<Model> call = retrofitAPI.postData();
////                call.enqueue(new retrofit2.Callback<Model>() {
//
//
//            }
//        });


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
