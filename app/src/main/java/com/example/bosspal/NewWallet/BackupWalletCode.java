package com.example.bosspal.NewWallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bosspal.MainActivity;
import com.example.bosspal.Models.CodeModel;
import com.example.bosspal.R;

import java.util.ArrayList;

public class BackupWalletCode extends AppCompatActivity {

    private Button continueBtn;
    private TextView mShowQr;
    private RecyclerView mCodeRecycler;
    WalletCodeAdapter codeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup_wallet_code);
        mCodeRecycler = findViewById(R.id.codeRecycler);
        continueBtn = findViewById(R.id.continueBtn);
        mShowQr = findViewById(R.id.showQr);

        walletCodesList();
        continueBtn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });
        mShowQr.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),QrCodeActivity.class);
            startActivity(intent);
        });



    }

    // Grid layout
    private void walletCodesList() {

        ArrayList<CodeModel> gridList = new ArrayList<>();

        gridList.add(new CodeModel(1,"code"));
        gridList.add(new CodeModel(2,"code"));
        gridList.add(new CodeModel(3,"code"));
        gridList.add(new CodeModel(4,"code"));
        gridList.add(new CodeModel(5,"code"));
        gridList.add(new CodeModel(6,"code"));
        gridList.add(new CodeModel(7,"code"));
        gridList.add(new CodeModel(8,"code"));
        gridList.add(new CodeModel(9,"code"));
        gridList.add(new CodeModel(10,"code"));
        gridList.add(new CodeModel(11,"code"));
        gridList.add(new CodeModel(12,"code"));


        codeAdapter = new WalletCodeAdapter(gridList,this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3, RecyclerView.VERTICAL,false);
        mCodeRecycler.setHasFixedSize(true);
        mCodeRecycler.setLayoutManager(layoutManager);
        mCodeRecycler.setAdapter(codeAdapter);
    }

}