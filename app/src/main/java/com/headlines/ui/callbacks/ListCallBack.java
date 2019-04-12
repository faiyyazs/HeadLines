package com.headlines.ui.callbacks;

import com.headlines.data.entities.FeedsEntityWithMedia;

public interface ListCallBack<T> {

     void onItemClick(FeedsEntityWithMedia entityWithMedia, T dataBinding);
}
