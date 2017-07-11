package com.example.rafal.pressreview.Data;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafal.pressreview.R;

/**
 * Created by Rafal on 7/11/2017.
 */

public class ProviderListAdapter extends RecyclerView.Adapter<ProviderListAdapter.ViewHolder> {
    Context mContext;
    Cursor mCursor;
    Resources resources;

    public ProviderListAdapter(Context context){
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.provider_single_item, parent, false);
        return new ProviderListAdapter.ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        resources = mContext.getResources();
        holder.providerNameTextView.setText(mCursor.getString(2));
        holder.providerDescriptionView.setText(mCursor.getString(3));

        Log.v("CURSOREK", mCursor.getString(1));

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


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView providerNameTextView;
        private TextView providerDescriptionView;
        private ImageView providerBrandImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            providerNameTextView = (TextView) itemView.findViewById(R.id.provider_name_view);
            providerDescriptionView = (TextView) itemView.findViewById(R.id.provider_description_view);
            providerBrandImageView = (ImageView) itemView.findViewById(R.id.provider_brand_view);
        }

        @Override
        public void onClick(View v) {
        }
    }


    public void iconizeProviderBrandView(String id){

    }
}
