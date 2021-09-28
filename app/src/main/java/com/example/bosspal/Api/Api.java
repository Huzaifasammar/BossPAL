package com.example.bosspal.Api;

import com.example.bosspal.Models.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    // Post Method use to put data to database

    @FormUrlEncoded
    @POST("end url come here")
    Call<ResponseModel> Login(
            @Field("email") String email,
            @Field("password") String password,
            @Field("device_token") String device_token

    );

    //Get Method use to get data from database

    @GET("end url come here")
    Call<ResponseModel> VerifyOTP(
            @Query("email") String email,
            @Query("otp") String otp

    );
}
