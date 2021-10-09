package com.example.bosspal.MainFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.bosspal.R;
import com.example.bosspal.SettingActivities.AboutActivity;
import com.example.bosspal.SettingActivities.AddSecurity;
import com.example.bosspal.SettingActivities.AddWallet;
import com.example.bosspal.SettingActivities.PushNotification;


public class SettingFragment extends Fragment {

    private RelativeLayout addWallet,mPush,mSecurity,mPriceAlert,mReference, mWalletConnect,
            mFacebookRl,twitterLt,telegramLt,HelpCenterRl,aboutLt;

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
        HelpCenterRl = view.findViewById(R.id.HelpCenterRl);
        //mPriceAlert = view.findViewById(R.id.priceAlertRL);
        //mReference = view.findViewById(R.id.referenceRl);
        //mWalletConnect = view.findViewById(R.id.WalletConnectRl);
        mFacebookRl = view.findViewById(R.id.facebookRl);
        twitterLt = view.findViewById(R.id.twitterLt);
        telegramLt = view.findViewById(R.id.telegramLt);
        aboutLt = view.findViewById(R.id.aboutLt);

        intentLink();

        mFacebookRl.setOnClickListener(view1 -> {

            gotoUrl("https://www.facebook.com/BossPalWallet");
        });
        twitterLt.setOnClickListener(view1 -> {

            gotoUrl("https://twitter.com/bosspalwallet");
        });
        twitterLt.setOnClickListener(view1 -> {

            gotoUrl("https://t.me/bosspalsupport");
        });

        HelpCenterRl.setOnClickListener(view1 -> {
            gotoUrl("support@bosspal.com");
        });

        telegramLt.setOnClickListener(view1 -> {
            gotoUrl("https://t.me/bosspalsupport");
        });


        return view;
    }

    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        getActivity().startActivity(new Intent(Intent.ACTION_VIEW,uri));
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

        aboutLt.setOnClickListener(view -> {
            startActivity(new Intent(SettingFragment.this.getActivity(), AboutActivity.class));
        });
    }
}