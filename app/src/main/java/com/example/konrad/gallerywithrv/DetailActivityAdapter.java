package com.example.konrad.gallerywithrv;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivityAdapter extends RecyclerView.Adapter<DetailActivityAdapter.ViewHolder> {

    private int[] imageIds;
    private String[] albumNames;
    private Context mContext;

    public DetailActivityAdapter(int[] imageIds, String[] albumNames, Context mContext) {
        this.imageIds = imageIds;
        this.albumNames = albumNames;
        this.mContext = mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    @Override
    public DetailActivityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_detail_image, parent, false);
        return new ViewHolder(cv);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);

        Glide.with(mContext).load(imageIds[position]).into(imageView);

        TextView textView = (TextView) cardView.findViewById(R.id.album_namer);
        textView.setText(albumNames[position]);

    }

    @Override
    public int getItemCount() {
        return imageIds.length;
    }
}
