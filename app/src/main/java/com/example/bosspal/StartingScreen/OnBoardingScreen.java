package com.example.bosspal.StartingScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bosspal.ImportWallet.ImportWalletList;
import com.example.bosspal.NewWallet.BackupWallet;
import com.example.bosspal.R;

public class OnBoardingScreen extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLinearLayout;
    private TextView[] mDots;
    private Button mWalletLink;
    private TextView mHaveWallet;


    private SliderAdapter sliderAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);

        mSlideViewPager=(ViewPager)findViewById(R.id.slide_viewpager);
        mDotLinearLayout=(LinearLayout)findViewById(R.id.dot_layout);
        mWalletLink = (Button)findViewById(R.id.newWalletLink);
        mHaveWallet = (TextView)findViewById(R.id.haveWalletTx);

        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mDotLinearLayout.setVisibility(View.VISIBLE);

        mSlideViewPager.addOnPageChangeListener(onPageChangeListener);

        mWalletLink.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), BackupWallet.class));

        });

        mHaveWallet.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ImportWalletList.class));
        });


    }
    public void addDotsIndicator(int position)
    {
        mDots = new TextView[4];
        mDotLinearLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            //mDots[i].setTextColor(getResources().getColor(R.color.white));

            mDotLinearLayout.addView(mDots[i]);
        }

        if(mDots.length > 0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.dark_green));
        }
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            /*
            if(i==0){
                mNextBtn.setVisibility(View.INVISIBLE);
            }
            else if(i==1){
                mNextBtn.setVisibility(View.INVISIBLE);
            }
            else if(i==2){
                next();
                mNextBtn.setVisibility(View.VISIBLE);
            }

            else if(i==3)
            {
                mDotLinearLayout.setVisibility(View.INVISIBLE);
                mGetStarted.setVisibility(View.VISIBLE);
            }*/
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

}