package com.example.rafal.pressreview;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafal.pressreview.Data.ProviderDataRequest;
import com.example.rafal.pressreview.Data.ProviderListAdapter;

import static com.example.rafal.pressreview.Data.NewsContentProvider.CONTENT_AUTHORITY;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.ID;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.PROVIDER_CATEGORY;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.PROVIDER_DESCRIPTION;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.PROVIDER_ID;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.PROVIDER_LANGUAGE;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.PROVIDER_NAME;
import static com.example.rafal.pressreview.Utilities.RetriveMyApplicationContext.getAppContext;


public class ProvidersFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    String[] projection = {ID, PROVIDER_ID, PROVIDER_NAME, PROVIDER_DESCRIPTION,
            PROVIDER_LANGUAGE, PROVIDER_CATEGORY};
    Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY + "/providers");
    private static final int PROVIDERS_LOADER = 1;
    ProviderListAdapter adapter;
    RecyclerView providerlistRecyclerView;

    public ProvidersFragment() {
    }



    public static ProvidersFragment newInstance() {
        ProvidersFragment fragment = new ProvidersFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        ProviderDataRequest providerDataRequest = new ProviderDataRequest();
        try {
            providerDataRequest.run("https://newsapi.org/v1/sources");
        } catch (Exception e) {
            e.printStackTrace();
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getLoaderManager().initLoader(PROVIDERS_LOADER, null, this);

        View rootView = inflater.inflate(R.layout.fragment_providers, container, false);

        providerlistRecyclerView = (RecyclerView) rootView.findViewById(R.id.providerlist);
        providerlistRecyclerView.setLayoutManager(new LinearLayoutManager(
                getAppContext(),
                LinearLayoutManager.VERTICAL,
                false));
        adapter = new ProviderListAdapter(getAppContext());
        adapter.notifyDataSetChanged();
        providerlistRecyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case PROVIDERS_LOADER:
                return new CursorLoader(
                        getActivity(),
                        BASE_CONTENT_URI,
                        projection,
                        null,
                        null,
                        null
                );
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }
}
