package com.example.rafal.pressreview.Data;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafal.pressreview.R;
import com.example.rafal.pressreview.Utilities.Iconize;
import com.squareup.picasso.Picasso;

import static com.example.rafal.pressreview.Utilities.RetriveMyApplicationContext.getAppContext;

/**
 * Created by Rafal on 7/6/2017.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    Iconize iconize;
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

        if (mCursor.getString(4).isEmpty()) {
            holder.newsImageView.setImageDrawable(resources.getDrawable(R.drawable.no_image));
        } else {
            Picasso.with(mContext).load(mCursor.getString(4)).into(holder.newsImageView);
        }

        holder.newsTitleView.setText(mCursor.getString(1));

        //setting icons
        Iconize.iconize(mCursor.getString(3), holder, resources);
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
        public ImageView providerImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            newsImageView = (ImageView) itemView.findViewById(R.id.news_image_view);
            newsTitleView = (TextView) itemView.findViewById(R.id.news_title_view);
            providerImageView = (ImageView) itemView.findViewById(R.id.provider_thumb_view);
        }


        @Override
        public void onClick(View v) {
            mCursor.moveToPosition(getAdapterPosition());
           Intent intent = new Intent(Intent.ACTION_VIEW);
           intent.setData(Uri.parse(mCursor.getString(3)));
           intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getAppContext().startActivity(intent);
        }
    }
}