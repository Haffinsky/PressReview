package com.example.rafal.pressreview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ProvidersFragment extends Fragment {


    public ProvidersFragment() {
    }


    // TODO: Rename and change types and number of parameters
    public static ProvidersFragment newInstance() {
        ProvidersFragment fragment = new ProvidersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_providers, container, false);
    }
}
