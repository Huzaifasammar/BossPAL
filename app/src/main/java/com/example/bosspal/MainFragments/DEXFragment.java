package com.example.bosspal.MainFragments;

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

import com.example.bosspal.R;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DEXFragment extends Fragment {

    private static ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabDexAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_d_e_x, container, false);
        mTabLayout=(TabLayout) view.findViewById (R.id.tab_layoutDex);
        mViewPager=(ViewPager) view.findViewById(R.id.viewPageDex);


        adapter = new TabDexAdapter(getActivity().getSupportFragmentManager());
        adapter.AddFragment(new DEXSwapFragment(),"Swap");
        adapter.AddFragment(new DEXExchangeFragment(),"Exchange");

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }


    private class TabDexAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        public void AddFragment(Fragment fragment,String s){
            fragmentArrayList.add(fragment);
            stringArrayList.add(s);
        }
        public TabDexAdapter(@NonNull @NotNull FragmentManager fm) {
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