package com.example.rafal.pressreview.Data;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafal.pressreview.R;
import com.squareup.picasso.Picasso;

import static com.example.rafal.pressreview.Utilities.RetriveMyApplicationContext.getAppContext;
import static com.example.rafal.pressreview.Utilities.Urls.AL_JAZEERA_ENGLISH_URL;
import static com.example.rafal.pressreview.Utilities.Urls.BBC_URL;
import static com.example.rafal.pressreview.Utilities.Urls.CNN_URL;
import static com.example.rafal.pressreview.Utilities.Urls.DAILY_MAIL_URL;
import static com.example.rafal.pressreview.Utilities.Urls.GOOGLE_NEWS_URL;
import static com.example.rafal.pressreview.Utilities.Urls.IGN_URL;
import static com.example.rafal.pressreview.Utilities.Urls.INDEPENDENT_URL;
import static com.example.rafal.pressreview.Utilities.Urls.NEWSWEEK_URL;

/**
 * Created by Rafal on 7/6/2017.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    Context mContext;
    Cursor mCursor;
    Resources resources;
    DataRequest dataRequest;

    public NewsListAdapter(Context context){
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.single_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mCursor.moveToPosition(position);

        dataRequest = new DataRequest();
        resources = mContext.getResources();
        Picasso.with(mContext).load(mCursor.getString(3)).into(holder.newsImageView);
        holder.newsTitleView.setText(mCursor.getString(0));
        //setting icons
        iconize(mCursor.getString(2), holder);


  }

    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        } else return mCursor.getCount();
    }

    public void swapCursor(final Cursor mCursor) {
        this.mCursor = mCursor;
        this.notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {;
        private TextView newsTitleView;
        private ImageView newsImageView;
        private ImageView providerView;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            newsImageView = (ImageView) itemView.findViewById(R.id.news_image_view);
            newsTitleView = (TextView) itemView.findViewById(R.id.news_title_view);
            providerView = (ImageView) itemView.findViewById(R.id.provider_thumb_view);
        }
        @Override
        public void onClick(View v) {
            mCursor.moveToPosition(getAdapterPosition());
           Intent intent = new Intent(Intent.ACTION_VIEW);
           intent.setData(Uri.parse(mCursor.getString(2)));
           intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getAppContext().startActivity(intent);
        }
    }
    public void iconize(String urlExtract, ViewHolder holder){
        if(urlExtract.contains("bbc")) {
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.bbc_news));
        } else if (urlExtract.contains("cnn")){
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.cnn_news));
        } else if (urlExtract.contains("independent")){
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.independent_news));
        } else if (urlExtract.contains("dailymail")) {
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.daily_mail_news));
        } else if (urlExtract.contains("indepenent")){
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.independent_news));
        } else  if (urlExtract.contains("economist")){
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.economist_news));
        } else if (urlExtract.contains("nytimes")){
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.newyorktimes_news));
        } else if (urlExtract.contains("wsj")){
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.wallstreet_news));
        } else if (urlExtract.contains("washingtonpost")){
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.washingtonpost_news));
        } else  if (urlExtract.contains("aljazeera")){
            holder.providerView.setImageDrawable(resources.getDrawable(R.drawable.aljazeera_news));
        } else {
            holder.providerView.setImageDrawable(null);
        }
    }
}