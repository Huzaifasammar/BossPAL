package com.example.bosspal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bosspal.Api.RetrofitClient;
import com.example.bosspal.MainFragments.DAppsFragment;
import com.example.bosspal.MainFragments.DEXFragment;
import com.example.bosspal.MainFragments.SettingFragment;
import com.example.bosspal.MainFragments.WalletFragment;
import com.example.bosspal.Models.ResponseModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String email,password,device_token;

    private BottomNavigationView mBottomNav;
    private Fragment fragment = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int containerFM =intent.getIntExtra("ide",0);

        bottomNavigation();

        // Sample Method to Call Api
        /*
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

         */
    }

    private void bottomNavigation() {
        // bottom navigation view
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation_id);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new WalletFragment()).commit();
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.walletF:
                        fragment = new WalletFragment();
                        break;

                    case R.id.D_appsF:
                        fragment = new DAppsFragment();
                        break;

                    case R.id.dexF:
                        fragment = new DEXFragment();
                        break;

                    case R.id.settingF:
                        fragment = new SettingFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).commit();
                return true;
            }
        });


    }
}