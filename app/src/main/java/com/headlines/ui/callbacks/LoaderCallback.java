package com.headlines.ui.callbacks;

import com.headlines.data.entities.FeedsEntityWithMedia;

public interface LoaderCallback {


    public void onSuccess(FeedsEntityWithMedia feedsEntityWithMedia);
    public void onFailure(String errorString);




}
