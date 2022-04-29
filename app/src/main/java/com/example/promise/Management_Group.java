package com.example.promise;

import static com.example.promise.retrofit.IPaddress.IPADRESS;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.promise.retrofit.RetrofitAPI;
import com.example.promise.retrofit.User_Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Management_Group extends AppCompatActivity {


    Button btn_group_out;
    private String group_id;
    TextView groupId;
    TextView groupCode;
    Button btn_list_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_group);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IPADRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        String user_login_id = sharedPref.getString("user_login_id", "");

        groupId = findViewById(R.id.group_id);


        Call<User_Model> call = retrofitAPI.findByUser_login_id(user_login_id);
        call.enqueue(new Callback<User_Model>() {
            @Override
            public void onResponse(Call<User_Model> call, Response<User_Model> response) {
                if (!response.isSuccessful()) {
                    Log.e("연결이 비정상적 : ", "error code : " + response.code());
                    return;
                }
                Log.e("response.body().getGroup_model()", response.body().getGroup_model().getId().toString());
                group_id = response.body().getGroup_model().getId().toString();
                groupId.setText(group_id + "번 그룹");


            }

            @Override
            public void onFailure(Call<User_Model> call, Throwable t) {
                Log.e("연결실패", t.getMessage());
            }
        });

//그룹나가기
        btn_group_out = findViewById(R.id.btn_group_out);
        btn_group_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<User_Model> call = retrofitAPI.deleteGroup(group_id, user_login_id);
                call.enqueue(new Callback<User_Model>() {
                    @Override
                    public void onResponse(Call<User_Model> call, Response<User_Model> response) {
                        if (!response.isSuccessful()) {
                            Log.e("연결이 비정상적 : ", "error code : " + response.code());
                            return;
                        }
                        Log.e("response.body()", response.body().toString());
                        Toast.makeText(getApplicationContext(), "그룹 탈퇴 성공!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<User_Model> call, Throwable t) {
                        Log.e("연결실패", t.getMessage());
                    }
                });
            }
        });

        btn_list_user = findViewById(R.id.btn_list_user);
        btn_list_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }
}
