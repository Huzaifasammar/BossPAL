package com.example.bosspal.MainFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bosspal.ImportWallet.WalletImportAdapter;
import com.example.bosspal.MainFragments.Adapters.TokenAdapter;
import com.example.bosspal.Models.TokenModel;
import com.example.bosspal.R;

import java.util.ArrayList;

public class WalletTokenFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private TokenAdapter adapter;
    private ImageView mSend,mReceive,mBuy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wallet_token, container, false);
        mRecyclerView = view.findViewById(R.id.preWalletCoinRecycler);
        initialise();

        preAddedCoin();

        return view;
    }

    private void initialise() {
        mSend = (ImageView)view.findViewById(R.id.sendArrow);
        mReceive = (ImageView)view.findViewById(R.id.receiveArrow);
        mBuy = (ImageView)view.findViewById(R.id.buyIcon);
    }

    private void preAddedCoin() {

        ArrayList<TokenModel> list = new ArrayList<>();
        list.add(new TokenModel(R.drawable.ic_tajiri,"Tajiri","$47.584","0.024","0BTC"));
        list.add(new TokenModel(R.drawable.ic_coin_yellow,"BNB","$47.584","0.024","0BTC"));
        list.add(new TokenModel(R.drawable.ic_coin_black,"Smart Chain","$47.584","0.024","0BTC"));
        list.add(new TokenModel(R.drawable.ic_ethereum,"Ethereum","$47.584","0.024","0BTC"));

        adapter = new TokenAdapter(list,getActivity());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),1, RecyclerView.VERTICAL,false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }


}