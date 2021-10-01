package com.example.bosspal.MainFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.bosspal.R;
import com.example.bosspal.SettingActivities.AddSecurity;
import com.example.bosspal.SettingActivities.AddWallet;
import com.example.bosspal.SettingActivities.PushNotification;


public class SettingFragment extends Fragment {

    private RelativeLayout addWallet,mPush,mSecurity,mPriceAlert,mReference, mWalletConnect;

    Context context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        addWallet = view.findViewById(R.id.addWalletLink);
        mPush = view.findViewById(R.id.addPushNoti);
        mSecurity = view.findViewById(R.id.addSecurity);
        mPriceAlert = view.findViewById(R.id.priceAlertRL);
        mReference = view.findViewById(R.id.referenceRl);
        mWalletConnect = view.findViewById(R.id.WalletConnectRl);

        intentLink();


        return view;
    }

    private void intentLink() {
        addWallet.setOnClickListener(view -> {
           startActivity(new Intent(SettingFragment.this.getActivity(), AddWallet.class));
        });

        mSecurity.setOnClickListener(view -> {
            startActivity(new Intent(SettingFragment.this.getActivity(), AddSecurity.class));
        });

        mPush.setOnClickListener(view -> {
            startActivity(new Intent(SettingFragment.this.getActivity(), PushNotification.class));
        });
    }
}