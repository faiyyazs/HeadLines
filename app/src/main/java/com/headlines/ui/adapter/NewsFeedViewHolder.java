package com.headlines.ui.adapter;

import android.content.Intent;

import com.headlines.R;
import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.databinding.LayoutItemNewsBinding;
import com.headlines.ui.callbacks.ListCallBack;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsFeedViewHolder extends RecyclerView.ViewHolder  {

    final LayoutItemNewsBinding layoutItemNewsBinding;


    public static NewsFeedViewHolder newInstance(@NonNull LayoutItemNewsBinding layoutItemNewsBinding) {
        return new NewsFeedViewHolder(layoutItemNewsBinding);
    }
    
    private NewsFeedViewHolder(@NonNull LayoutItemNewsBinding layoutItemNewsBinding) {
        super(layoutItemNewsBinding.getRoot());
        this.layoutItemNewsBinding = layoutItemNewsBinding;
    }

    public void bindView(final FeedsEntityWithMedia entityWithMedia, final ListCallBack listCallBack){
        this.layoutItemNewsBinding.setFeed(entityWithMedia);
        this.layoutItemNewsBinding.element.setOnClickListener(v -> listCallBack.onItemClick(entityWithMedia,layoutItemNewsBinding));
        this.layoutItemNewsBinding.readMore.setOnClickListener(v -> listCallBack.onItemClick(entityWithMedia,layoutItemNewsBinding));
        this.layoutItemNewsBinding.share.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, v.getResources().getString(R.string.linkDescription)+ entityWithMedia.feedsEntity.getUrl());
            sendIntent.setType("text/plain");
            v.getContext().startActivity(Intent.createChooser(sendIntent, v.getContext().getResources().getText(R.string.dbinspector_action_share)));


        });
        this.layoutItemNewsBinding.executePendingBindings();
    }



}
