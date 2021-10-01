package com.example.bosspal.MainFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bosspal.MainFragments.DAppAdapter.NewDAppAdapter;
import com.example.bosspal.Models.CodeModel;
import com.example.bosspal.Models.NewDAppModel;
import com.example.bosspal.NewWallet.WalletCodeAdapter;
import com.example.bosspal.R;

import java.util.ArrayList;


public class DAppsFragment extends Fragment {

    private NewDAppAdapter appAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_d_apps, container, false);

        recyclerView = view.findViewById(R.id.newApp_recycler);
        walletCodesList();
        return view;
    }


    // Grid layout
    private void walletCodesList() {

        ArrayList<NewDAppModel> gridList = new ArrayList<>();

        gridList.add(new NewDAppModel(R.drawable.ic_bitcoin,"PowerPool","PowerPool is a DAO manager of etc."));
        gridList.add(new NewDAppModel(R.drawable.ic_bitcoin,"PowerPool","PowerPool is a DAO manager of etc."));
        gridList.add(new NewDAppModel(R.drawable.ic_bitcoin,"PowerPool","PowerPool is a DAO manager of etc."));
        gridList.add(new NewDAppModel(R.drawable.ic_bitcoin,"PowerPool","PowerPool is a DAO manager of etc."));
        gridList.add(new NewDAppModel(R.drawable.ic_bitcoin,"PowerPool","PowerPool is a DAO manager of etc."));
        gridList.add(new NewDAppModel(R.drawable.ic_bitcoin,"PowerPool","PowerPool is a DAO manager of etc."));
        gridList.add(new NewDAppModel(R.drawable.ic_bitcoin,"PowerPool","PowerPool is a DAO manager of etc."));
        gridList.add(new NewDAppModel(R.drawable.ic_bitcoin,"PowerPool","PowerPool is a DAO manager of etc."));



        appAdapter = new NewDAppAdapter(gridList,DAppsFragment.this.getActivity());
        GridLayoutManager layoutManager = new GridLayoutManager(DAppsFragment.this.getActivity(),3, RecyclerView.HORIZONTAL,false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(appAdapter);
    }

}