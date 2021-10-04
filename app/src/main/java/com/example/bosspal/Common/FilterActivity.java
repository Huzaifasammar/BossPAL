package com.example.bosspal.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bosspal.ImportWallet.WalletImportAdapter;
import com.example.bosspal.Models.FilterModel;
import com.example.bosspal.R;

import java.util.ArrayList;

public class FilterActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FilterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        mRecyclerView = findViewById(R.id.filter_Recycler);

        ArrayList<FilterModel> list = new ArrayList<>();

        list.add(new FilterModel(R.drawable.ic_tajiri,"Tajiri","on"));
        list.add(new FilterModel(R.drawable.ic_coin_yellow,"BNB","on"));
        list.add(new FilterModel(R.drawable.ic_coin_black,"Smart Chain","on"));
        list.add(new FilterModel(R.drawable.ic_bitcoin,"Bitcoin","on"));
        list.add(new FilterModel(R.drawable.ic_ethereum,"Ethereum","on"));


        adapter = new FilterAdapter(list,this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
    }
}