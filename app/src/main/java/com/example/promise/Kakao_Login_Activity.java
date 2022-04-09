package com.example.promise;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
public class Kakao_Login_Activity extends AppCompatActivity {
    private final static String TAG = "유저";
    private Button kakaoAuth, googleAuth;
    public static Context mContext;
    private SharedPreferences sharedPreferences;
    private User currentUser;
    private String userImageString = "";
    private Bitmap mBitmap;
    SharedPreferences.Editor editor;
    private Boolean isTrue = false;
    private Boolean nextIntent = false;
    private String meetingId;
    private Intent intent;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kakao_login);
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if (oAuthToken != null) {
                    Log.i("user", oAuthToken.getAccessToken() + " " + oAuthToken.getRefreshToken());
                }
                if (throwable != null) {
                    Log.w(TAG, "invoke: " + throwable.getLocalizedMessage());
                }
                updateKakaoLoginUi();
                return null;
            }
        };
        kakaoAuth = findViewById(R.id.kakao_auth_button);
        kakaoAuth.setOnClickListener(new View.OnClickListener() {
            // 로그인 버튼 클릭 시
            @Override
            public void onClick(View v) {
                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(Kakao_Login_Activity.this)) {
                    UserApiClient.getInstance().loginWithKakaoTalk(Kakao_Login_Activity.this, callback);
                } else {
                    UserApiClient.getInstance().loginWithKakaoAccount(Kakao_Login_Activity.this, callback);
                }
            }
        });
        updateKakaoLoginUi();
    }

    public void updateKakaoLoginUi() {
        UserApiClient.getInstance().me((user, throwable) -> {
            if (user != null) {
                Log.i(TAG, "id " + user.getId());
                Log.i(TAG, "invoke: nickname=" + user.getKakaoAccount().getProfile().getNickname());
                Log.i(TAG, "userimage " + user.getKakaoAccount().getProfile().getProfileImageUrl());
            }
            if (throwable != null) { // 로그인 시 오류 났을 때 // 키해시가 등록 안 되어 있으면 오류 납니다.
                Log.w(TAG, "invoke: " + throwable.getLocalizedMessage());
            }
            return null;
        });
    }
}



//   <meta-data
//            android:name="com.kakao.sdk.AppKey"
//            android:value=	"13fdc35e90c9a79646e3de36f199f936"/>

//
