package com.example.bosspal.MainFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bosspal.MainFragments.Adapters.TokenAdapter;
import com.example.bosspal.MainFragments.BottomSheets.TokenBuyFragment;
import com.example.bosspal.MainFragments.BottomSheets.TokenReceiveFragment;
import com.example.bosspal.MainFragments.BottomSheets.TokenSendFragment;
import com.example.bosspal.MainFragments.BottomSheets.TokenSwapFragment;
import com.example.bosspal.Models.TokenModel;
import com.example.bosspal.R;

import java.util.ArrayList;

public class WalletTokenFragment extends Fragment {

    private View view;
    private RecyclerView mRecyclerView;
    private TokenAdapter adapter;
    private ImageView mSend,mReceive,mBuy,mSwap;

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
        mSwap = (ImageView)view.findViewById(R.id.swapIcon);


        mSend.setOnClickListener(view1 -> {
            TokenSendFragment tokenSendFragment = new TokenSendFragment();
            tokenSendFragment.show(getActivity().getSupportFragmentManager(),tokenSendFragment.getTag());
        });

        mReceive.setOnClickListener(view1 -> {
            TokenReceiveFragment receiveFragment = new TokenReceiveFragment();
            receiveFragment.show(getActivity().getSupportFragmentManager(),receiveFragment.getTag());
        });

        mBuy.setOnClickListener(view1 -> {
            TokenBuyFragment buyFragment = new TokenBuyFragment();
            buyFragment.show(getActivity().getSupportFragmentManager(),buyFragment.getTag());
        });

        mSwap.setOnClickListener(view1 -> {
            TokenSwapFragment swapFragment = new TokenSwapFragment();
            swapFragment.show(getActivity().getSupportFragmentManager(),swapFragment.getTag());
        });
    }

    private void preAddedCoin() {

        ArrayList<TokenModel> list = new ArrayList<>();
        list.add(new TokenModel(R.drawable.ic_tajiri,"Tajiri","$47.584","0.024","0BTC"));
        list.add(new TokenModel(R.drawable.ic_coin_yellow,"BNB","$47.584","0.024","0BTC"));
        list.add(new TokenModel(R.drawable.ic_coin_black,"Smart Chain","$47.584","0.024","0BTC"));
        list.add(new TokenModel(R.drawable.ic_ethereum,"Ethereum","$47.584","0.024","0BTC"));

        adapter = new TokenAdapter(list,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }


}