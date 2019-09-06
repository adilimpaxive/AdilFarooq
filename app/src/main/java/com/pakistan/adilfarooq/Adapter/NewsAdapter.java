package com.pakistan.adilfarooq.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pakistan.adilfarooq.Model.News;
import com.pakistan.adilfarooq.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewholder> {

    private Context mContext;
    private List<News> mNewsList;

    public NewsAdapter(Context mContext, List<News> mNewsList) {
        this.mContext = mContext;
        this.mNewsList = mNewsList;
    }

    @NonNull
    @Override
    public NewsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.news_items, parent, false);
        return new NewsViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewholder holder, int position) {

        News object = mNewsList.get(position);

        loadImage(object.getmImageUrl(), holder.mImageHolder);
        holder.mDescriptionHolder.setText(object.getmDescription());
    }

    private void loadImage(String image, ImageView imageView) {
        if(image == null){
            Glide
                    .with(mContext)
                    .load(R.drawable.nature)
                    .into(imageView);
        }else {
            Glide
                    .with(mContext)
                    .load(image)
                    .into(imageView);
        }
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class NewsViewholder extends RecyclerView.ViewHolder {

        private ImageView mImageHolder;
        private TextView mDescriptionHolder;

        public NewsViewholder(@NonNull View itemView) {
            super(itemView);

            mImageHolder = itemView.findViewById(R.id.image_holder);
            mDescriptionHolder = itemView.findViewById(R.id.lorem_tv);
        }
    }
}
