package com.example.rafal.pressreview;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.rafal.pressreview.Data.NewsDatabaseHelper;
import com.example.rafal.pressreview.Data.SingleProviderDataRequest;
import com.example.rafal.pressreview.Utilities.Iconize;

import static com.example.rafal.pressreview.Utilities.RetriveMyApplicationContext.getAppContext;

public class SingleProviderNews extends AppCompatActivity {
    Iconize iconize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_provider_news);
        addFragments();

        Window window = getWindow();
        iconize = new Iconize();
        iconize.blackenSystemBar(window);
    }

    public void addFragments() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new SingleProviderNewsFragment();
        fragmentTransaction.replace(R.id.activity_single_provider_news, fragment).commit();
    }
}
