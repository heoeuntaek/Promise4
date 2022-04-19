//package com.example.promise.retrofit;
//
//import android.util.Log;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class CallRestrofit {
//
//
//    public void findById(String id){
//        //Retrofit 호출
////        Model model = new Model();
//        Call<Model> call = RetrofitClient.getApiService().getData();
//        call.enqueue(new Callback<Model>() {
//            @Override
//            public void onResponse(Call<Model> call, Response<Model> response) {
//                if(!response.isSuccessful()){
//                    Log.e("연결이 비정상적 : ", "error code : " + response.code());
//                    return;
//                }
//                Model checkAlready = response.body();
//                Log.d("연결이 성공적 : ", response.body().toString());
//            }
//            @Override
//            public void onFailure(Call<Model> call, Throwable t) {
//                Log.e("연결실패", t.getMessage());
//            }
//        });
//
//
//    }
//}
