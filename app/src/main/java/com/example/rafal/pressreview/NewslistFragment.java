package com.example.rafal.pressreview;

import android.content.Context;
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

import com.example.rafal.pressreview.Data.DataRequest;
import com.example.rafal.pressreview.Data.NewsDatabaseHelper;
import com.example.rafal.pressreview.Data.NewsListAdapter;

import static com.example.rafal.pressreview.Data.NewsContentProvider.CONTENT_AUTHORITY;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.ARTICLE_URL;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.DESCRIPTION;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.IMAGE_URL;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.TITLE;
import static com.example.rafal.pressreview.Data.NewsDatabaseHelper.ID;
import static com.example.rafal.pressreview.Utilities.RetriveMyApplicationContext.getAppContext;
import static com.example.rafal.pressreview.Utilities.Urls.AL_JAZEERA_ENGLISH_URL;
import static com.example.rafal.pressreview.Utilities.Urls.BBC_URL;
import static com.example.rafal.pressreview.Utilities.Urls.CNN_URL;
import static com.example.rafal.pressreview.Utilities.Urls.DAILY_MAIL_URL;
import static com.example.rafal.pressreview.Utilities.Urls.ECONOMIST_URL;
import static com.example.rafal.pressreview.Utilities.Urls.INDEPENDENT_URL;
import static com.example.rafal.pressreview.Utilities.Urls.NEWSWEEK_URL;
import static com.example.rafal.pressreview.Utilities.Urls.NEWYORKTIMES_URL;
import static com.example.rafal.pressreview.Utilities.Urls.WALLSTREET_URL;
import static com.example.rafal.pressreview.Utilities.Urls.WASHINGTONPOST_URL;


public class NewslistFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    String[] projection = {ID, TITLE, DESCRIPTION, ARTICLE_URL, IMAGE_URL};
    Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY + "/news");
    private static final int NEWS_LOADER = 0;
    NewsListAdapter adapter;
    RecyclerView newslistRecyclerView;

    public NewslistFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static NewslistFragment newInstance() {
        NewslistFragment fragment = new NewslistFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataRequest dataRequest = new DataRequest();
        try {
            dataRequest.run(BBC_URL);
            dataRequest.run(AL_JAZEERA_ENGLISH_URL);
            dataRequest.run(CNN_URL);
            dataRequest.run(WASHINGTONPOST_URL);
            dataRequest.run(DAILY_MAIL_URL);
            dataRequest.run(WALLSTREET_URL);
            dataRequest.run(INDEPENDENT_URL);
            dataRequest.run(ECONOMIST_URL);
            dataRequest.run(NEWYORKTIMES_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getLoaderManager().initLoader(NEWS_LOADER, null, this);

        View rootView = inflater.inflate(R.layout.fragment_newslist, container, false);

        newslistRecyclerView = (RecyclerView) rootView.findViewById(R.id.newslist);
        newslistRecyclerView.setLayoutManager(new LinearLayoutManager(
                getAppContext(),
                LinearLayoutManager.VERTICAL,
                false));
        adapter = new NewsListAdapter(getAppContext());
        adapter.notifyDataSetChanged();
        newslistRecyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case NEWS_LOADER:
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


