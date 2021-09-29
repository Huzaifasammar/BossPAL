package com.example.bosspal.ImportWallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bosspal.Models.CodeModel;
import com.example.bosspal.Models.WalletListModel;
import com.example.bosspal.NewWallet.WalletCodeAdapter;
import com.example.bosspal.R;

import java.util.ArrayList;

public class ImportWalletList extends AppCompatActivity {

    private RecyclerView walletList;

    private WalletImportAdapter importAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_wallet_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Import");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        walletList = findViewById(R.id.walletList);

        walletList();
    }

    // Grid layout
    private void walletList() {

        ArrayList<WalletListModel> gridList = new ArrayList<>();

        gridList.add(new WalletListModel("BNB",R.drawable.ic_wallet));
        gridList.add(new WalletListModel("BNB",R.drawable.ic_wallet));
        gridList.add(new WalletListModel("BNB",R.drawable.ic_wallet));
        gridList.add(new WalletListModel("BNB",R.drawable.ic_wallet));
        gridList.add(new WalletListModel("BNB",R.drawable.ic_wallet));
        gridList.add(new WalletListModel("BNB",R.drawable.ic_wallet));
        gridList.add(new WalletListModel("BNB",R.drawable.ic_wallet));




        importAdapter = new WalletImportAdapter(gridList,this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1, RecyclerView.VERTICAL,false);
        walletList.setHasFixedSize(true);
        walletList.setLayoutManager(layoutManager);
        walletList.setAdapter(importAdapter);
    }
}