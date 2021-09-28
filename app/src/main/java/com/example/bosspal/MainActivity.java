package com.example.bosspal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bosspal.Api.RetrofitClient;
import com.example.bosspal.Models.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String email,password,device_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample Method to Call Api

        Call<ResponseModel> call = RetrofitClient
                .getInstance()
                .api()
                .Login(email,password,device_token);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.body().getMessage().equals("200"))
                {
                    // Successfull Response
                }
                else
                {
                    // Response Fail
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
               // Database or Api error
            }
        });
    }
}