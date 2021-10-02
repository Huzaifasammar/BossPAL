package com.example.bosspal.MainFragments;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bosspal.Common.FilterActivity;
import com.example.bosspal.Common.NotificationActivity;
import com.example.bosspal.R;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static android.view.View.*;

public class WalletFragment extends Fragment {

    private static ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ImageView mFilterData,mNotification;

    TabAdapter adapter;
    private static final String fragment_Id="fragmentId";


    public static WalletFragment walletFragment(int i){
        Bundle bundle = new Bundle();
        bundle.putInt(fragment_Id,i);
        WalletFragment walletFragment = new WalletFragment();
        walletFragment.setArguments(bundle);
        return walletFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_wallet, container, false);
        mTabLayout=(TabLayout) v.findViewById (R.id.tab_layout);
        mViewPager=(ViewPager) v.findViewById(R.id.viewPage);
        mNotification=(ImageView) v.findViewById(R.id.notification_icon);
        mFilterData=(ImageView) v.findViewById(R.id.filter_icon);


        adapter = new TabAdapter(getActivity().getSupportFragmentManager());
        adapter.AddFragment(new WalletTokenFragment(),"Token");
        adapter.AddFragment(new WalletFinanceFragment(),"Finance");
        adapter.AddFragment(new WalletCollectFragment(),"Collect");

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

        clickListener();
        return v;
    }


    private void clickListener(){
        mFilterData.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), FilterActivity.class);
            startActivity(intent);
        });

        mNotification.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), NotificationActivity.class);
            startActivity(intent);
        });
    }

    // Adapter for TabLayout
    private class TabAdapter extends FragmentPagerAdapter{
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        public void AddFragment(Fragment fragment,String s){
            fragmentArrayList.add(fragment);
            stringArrayList.add(s);
        }

        public TabAdapter(@NonNull @NotNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @NotNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            //return super.getPageTitle(position);

            return stringArrayList.get(position);
        }
    }

}