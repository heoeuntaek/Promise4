package com.example.promise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.promise.retrofit.Model;
import com.example.promise.retrofit.RetrofitAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Register extends AppCompatActivity {

    EditText text;
    EditText text2;
    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        text = (EditText) findViewById(R.id.text11);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.34.97.79:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);



        Call<Model> call = retrofitAPI.getData();

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
//                if(response.isSuccessful()){
                if(!response.isSuccessful()){
                    Log.e("연결이 비정상적 : ", "error code : " + response.code());
                    return;
                }

                Log.d("TAG", response.body() + "");

                text.setText(response.body().toString());


            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

                Log.e("연결실패", t.getMessage());

            }
        });


        btn = (Button) findViewById(R.id.get_method_btn);
        text2 = (EditText) findViewById(R.id.page_input_edit_text);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Call<Model> call = retrofitAPI.getDataById(text2.getText().toString());

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {

                        if(!response.isSuccessful()){
                            Log.e("연결이 비정상적 : ", "error code : " + response.code());
                            return;
                        }

                        Log.d("TAG", response.body() + "");

                        text.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                        Log.e("연결실패", t.getMessage());
                    }
                });

            }




        });





        btn2 = (Button) findViewById(R.id.btn_register);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userId = (EditText) findViewById(R.id.user_id_login);
                EditText userPass = (EditText) findViewById(R.id.user_pass_register);
                EditText userName = (EditText) findViewById(R.id.user_name_register);

                String user_id = userId.getText().toString();
                String user_pass = userPass.getText().toString();
                String user_name = userName.getText().toString();


                Model model = new Model(user_id, user_pass, user_name);
                Log.d("보낼데이터", model.toString());

//                Call<Model> call = retrofitAPI.postData(user_id, user_pass, user_name);
                Call<Model> call = retrofitAPI.postData(model);
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        if(!response.isSuccessful()){
                            Log.e("연결이 비정상적 : ", "error code : " + response.code());
                            Toast.makeText(getApplicationContext(), "중복된 id입니다.", Toast.LENGTH_LONG).show();
                            return;
                        }

                        Log.d("보낸데이터", model.toString());
                        Log.d("연결이 성공적 : ", response.body().toString());

                        text.setText(response.body().getUser_id()+"님 환영합니다");
                        Toast.makeText(getApplicationContext(), "회원가입이 정상적으로 되었습니다.", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(), Kakao_Login_Activity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Log.e("연결실패", t.getMessage());
                    }
                });

                }
            });
        };

    }







