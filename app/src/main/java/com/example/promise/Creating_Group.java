package com.example.promise;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.promise.retrofit.Group_Model;
import com.example.promise.retrofit.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Creating_Group extends AppCompatActivity {

    EditText groupName;
    Button btn;
    int there_is_group = 0; //그룹 없는 상태

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_group);


        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String user_login_id = sharedPref.getString("user_login_id", "");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.83.64:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        btn = (Button) findViewById(R.id.create);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                groupName = findViewById(R.id.group_name);
                String group_name = Creating_Group.this.groupName.getText().toString();
                Group_Model group_created = new Group_Model();
                group_created.setGroup_name(group_name);

                RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

                Call<Group_Model> call2 = retrofitAPI.createGroup(user_login_id, group_created);
                //@Path("user_login_id") String user_login_id, @Body
                call2.enqueue(new Callback<Group_Model>() {
                    @Override
                    public void onResponse(Call<Group_Model> call, Response<Group_Model> response) {

                        if (!response.isSuccessful()) {
                            Log.e("연결이 비정상적 : ", "error code : " + response.code());
                            return;
                        }


                        Log.d("보낸데이터", group_created.toString());
                        Log.d("연결이 성공적 : ", response.body().toString());

                        Toast.makeText(getApplicationContext(), "그룹생성 되었습니다.", Toast.LENGTH_LONG).show();

                        Group_Model group_model = response.body();
                        Intent intent = new Intent(Creating_Group.this, MainActivity.class);
                        startActivity(intent);


                    }

                    @Override
                    public void onFailure(Call<Group_Model> call, Throwable t) {
                        Log.e("연결실패", t.getMessage());

                    }
                });

            }
        });

        ;

    };
}



//                call.enqueue(new retrofit2.Callback<Model>() {






