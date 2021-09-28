package com.example.bosspal.NewWallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.bosspal.R;

public class BackupWallet extends AppCompatActivity {

    private CheckBox mCheck;
    private Button mContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_wallet);
        mCheck=findViewById(R.id.iUnderstandCheck);
        mContinue= findViewById(R.id.continueBtn);

        mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mCheck.isChecked()){
                    mContinue.setEnabled(true);
                    mContinue.setOnClickListener(view -> {
                        startActivity(new Intent(getApplicationContext(),BackupWalletCode.class));
                    });
                }else {
                    mContinue.setEnabled(false);
                }
            }
        });
    }
}