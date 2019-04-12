package com.headlines.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.databinding.LayoutItemNewsBinding;
import com.headlines.ui.BaseAdapter;
import com.headlines.ui.callbacks.ListCallBack;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class NewsFeedsListAdapter extends BaseAdapter<NewsFeedViewHolder, FeedsEntityWithMedia> {


    private List<FeedsEntityWithMedia> newsEntities;
    private ListCallBack listCallBack;

    public NewsFeedsListAdapter(ListCallBack listCallBack){
        this.newsEntities = new ArrayList<>();
        this.listCallBack  = listCallBack;
    }

    @Override
    public void setData(List<FeedsEntityWithMedia> data) {
        this.newsEntities = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NewsFeedViewHolder.newInstance(
                LayoutItemNewsBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedViewHolder holder, int position) {
        holder.bindView(this.newsEntities.get(position),this.listCallBack);
    }

    @Override
    public int getItemCount() {
        return this.newsEntities.size();
    }
}
