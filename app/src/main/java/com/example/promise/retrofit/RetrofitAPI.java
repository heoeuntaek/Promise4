package com.example.promise.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitAPI {

    //    Call<Model> findById(@Body Model model); //이건 바디 요청시 사용하는거
    @GET("api/users/1")
    Call<Model> getData();

    @GET("api/users/{id}")
    Call<Model> getDataById(@Path("id") String id);


    @POST("api/users")
    Call<Model> postRegister(@Body Model model);

    @POST("api/login")
    Call<Model> postLogin(@Body Model model);

//    @FormUrlEncoded
//    @POST("api/users")
//    Call<Model> postData(
//            @Field("user_id") String user_id,
//            @Field("user_pass") String user_pass,
//            @Field("user_name") String user_name
//    );

    //@FormUrlEncoded
    //@POST("/auth/overlapChecker")
    //Call<Model__CheckAlready> postOverlapCheck(@Field("phone") String phoneNum, @Field("message") String message); //이건 요청시 사용하는거 (*데이터를 보낼때)
}



