package com.example.bosspal.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    private static final String BASE_URL = "BaseURl Comes Here";
    private static RetrofitClient client;
    private static Retrofit retrofit = null;
    private static final int TIME_OUT = 30000;

    private RetrofitClient() {
        if (retrofit == null) {
            OkHttpClient.Builder c = new OkHttpClient.Builder();
            c.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
            c.readTimeout(TIME_OUT, TimeUnit.SECONDS);
            c.writeTimeout(TIME_OUT, TimeUnit.SECONDS);

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(BASE_URL)
                    .build();

        }
    }

    public static synchronized RetrofitClient getInstance() {
        if (client == null) {
            client = new RetrofitClient();
        }
        return client;
    }



    public Api api() {
        return retrofit.create(Api.class);
    }
}
