package com.example.bosspal.WalletList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bosspal.MainFragments.DEXExchangeFragment;
import com.example.bosspal.MainFragments.DEXFragment;
import com.example.bosspal.MainFragments.DEXSwapFragment;
import com.example.bosspal.R;
import com.example.bosspal.StartingScreen.OnBoardingScreen;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HaveWalletActivity extends AppCompatActivity {

    private static ViewPager mViewPager;
    private TabLayout mTabLayout;
    private HaveWalletAdapter adapter;

    String mWalletName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_wallet);
        mTabLayout=(TabLayout)findViewById (R.id.tab_layoutHave);
        mViewPager=(ViewPager)findViewById(R.id.viewPageHave);
        Toolbar toolbar = findViewById(R.id.haveWalletToolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);


        adapter = new HaveWalletActivity.HaveWalletAdapter(this.getSupportFragmentManager());


        mWalletName = getIntent().getStringExtra("WalletName");

        if (mWalletName.equals("MultiChain")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
        }else if (mWalletName.equals("Ethereum")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
            adapter.AddFragment(new KeyStoreJsonFragment(),"KETSTORE JSON");
            adapter.AddFragment(new PrivateKeyFragment(),"PRIVATE KEY");
            adapter.AddFragment(new AddressFragment(),"ADDRESS");


        }else if (mWalletName.equals("Smart Chain")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
            adapter.AddFragment(new KeyStoreJsonFragment(),"KETSTORE JSON");
            adapter.AddFragment(new PrivateKeyFragment(),"PRIVATE KEY");
            adapter.AddFragment(new AddressFragment(),"ADDRESS");

        }else if(mWalletName.equals("Polkadot")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
            adapter.AddFragment(new AddressFragment(),"ADDRESS");

        }else if (mWalletName.equals("XRP")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
            adapter.AddFragment(new AddressFragment(),"ADDRESS");

        }else if (mWalletName.equals("Polygon")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
            adapter.AddFragment(new KeyStoreJsonFragment(),"KETSTORE JSON");
            adapter.AddFragment(new PrivateKeyFragment(),"PRIVATE KEY");
            adapter.AddFragment(new AddressFragment(),"ADDRESS");
        }
        else if (mWalletName.equals("Stellar")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
            adapter.AddFragment(new KeyStoreJsonFragment(),"KETSTORE JSON");
            adapter.AddFragment(new PrivateKeyFragment(),"PRIVATE KEY");
            adapter.AddFragment(new AddressFragment(),"ADDRESS");

        }else if (mWalletName.equals("Tezos")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
            adapter.AddFragment(new AddressFragment(),"ADDRESS");
        }
        else if (mWalletName.equals("Theta")){
            toolbar.setTitle("Import "+mWalletName);
            setSupportActionBar(toolbar);
            adapter.AddFragment(new PhrasFragment(),"PHRASE");
            adapter.AddFragment(new PrivateKeyFragment(),"PRIVATE KEY");
            adapter.AddFragment(new AddressFragment(),"ADDRESS");
        }



        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private class HaveWalletAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        public void AddFragment(Fragment fragment,String s){
            fragmentArrayList.add(fragment);
            stringArrayList.add(s);
        }
        public HaveWalletAdapter(@NonNull @NotNull FragmentManager fm) {
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

            return stringArrayList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.have_wallet_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.haveWalletScanner){

            Toast.makeText(this,"Open Camera",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}