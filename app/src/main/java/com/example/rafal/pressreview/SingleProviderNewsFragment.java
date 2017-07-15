package com.example.rafal.pressreview;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafal.pressreview.Data.NewsDatabaseHelper;
import com.example.rafal.pressreview.Data.SingleProviderAdapter;
import com.example.rafal.pressreview.Data.SingleProviderDataRequest;

import static com.example.rafal.pressreview.Data.NewsContentProvider.CONTENT_AUTHORITY;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.ID;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.PROVIDER_ARTICLE_URL;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.PROVIDER_IMAGE_URL;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.PROVIDER_NEWS_TITLE;
import static com.example.rafal.pressreview.Utilities.RetriveMyApplicationContext.getAppContext;


public class SingleProviderNewsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    String[] projection = {ID, PROVIDER_NEWS_TITLE, PROVIDER_ARTICLE_URL, PROVIDER_IMAGE_URL};
    Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY + "/providerNews");
    private static final int PROVIDER_NEWS_LOADER = 1;
    SingleProviderAdapter adapter;
    RecyclerView singleProviderNewsRecycleView;

    public SingleProviderNewsFragment() {
    }

    // TODO: Rename and change types and number of parameters
    public static SingleProviderNewsFragment newInstance() {
        SingleProviderNewsFragment fragment = new SingleProviderNewsFragment();
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

        Intent intent = getActivity().getIntent();
        String provider_id = intent.getStringExtra("provider_id");

        Log.v("PROVIDER ID", provider_id);

        String URL = "https://newsapi.org/v1/articles?source=" +
                provider_id +
                "&apiKey=973797423811403398a18d3ea62965b1";

        SingleProviderDataRequest dataRequest = new SingleProviderDataRequest();
        try {
            dataRequest.run(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getLoaderManager().initLoader(PROVIDER_NEWS_LOADER, null, this);

        View rootView = inflater.inflate(R.layout.fragment_single_provider_news, container, false);

        singleProviderNewsRecycleView = (RecyclerView) rootView.findViewById(R.id.single_provider_newslist);
        singleProviderNewsRecycleView.setLayoutManager(new LinearLayoutManager(
                getAppContext(),
                LinearLayoutManager.VERTICAL,
                false));
        adapter = new SingleProviderAdapter(getAppContext());
        adapter.notifyDataSetChanged();
        singleProviderNewsRecycleView.setAdapter(adapter);


        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case PROVIDER_NEWS_LOADER:
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