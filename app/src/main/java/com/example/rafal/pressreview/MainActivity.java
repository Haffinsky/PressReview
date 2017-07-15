package com.example.rafal.pressreview;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.rafal.pressreview.Data.NewsDatabaseHelper;
import com.example.rafal.pressreview.Utilities.Iconize;
import com.kekstudio.dachshundtablayout.DachshundTabLayout;

import static com.example.rafal.pressreview.Utilities.RetriveMyApplicationContext.getAppContext;

public class MainActivity extends AppCompatActivity {
    NewsDatabaseHelper newsDatabaseHelper;
    Iconize iconize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        DachshundTabLayout tabLayout = (DachshundTabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        Window window = getWindow();
        iconize = new Iconize();
        iconize.blackenSystemBar(window);

    }

    public static class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return NewslistFragment.newInstance();
                case 1:
                    return ProvidersFragment.newInstance();
                default:
                    return NewslistFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "PRESS REVIEW";
                case 1: return "SEARCH BY PROVIDER";
                default: return "PRESS REVIEW";
            }
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        newsDatabaseHelper = new NewsDatabaseHelper(getAppContext());
        newsDatabaseHelper.dropAndRecreateNewsTable();
        newsDatabaseHelper.dropAndRecreateProviderTable();
        newsDatabaseHelper.dropAndRecreateProviderNewsTable();
    }
}


