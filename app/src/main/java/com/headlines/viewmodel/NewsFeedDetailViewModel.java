package com.headlines.viewmodel;

import android.app.Application;
import android.util.Log;

import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.repository.NewsFeedsRepository;
import com.headlines.ui.callbacks.LoaderCallback;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsFeedDetailViewModel extends ViewModel {


    private NewsFeedsRepository newsFeedsRepository;

    public MutableLiveData<FeedsEntityWithMedia> getFeedsEntityWithMediaMutableLiveData() {
        return feedsEntityWithMediaMutableLiveData;
    }

    private MutableLiveData<FeedsEntityWithMedia> feedsEntityWithMediaMutableLiveData = new MutableLiveData<>();


    public NewsFeedDetailViewModel(@NonNull Application application,
                                   NewsFeedsRepository newsFeedsRepository) {
        this.newsFeedsRepository = newsFeedsRepository;
    }

    public void loadFeedsInformation(FeedsEntityWithMedia feedsEntityWithMedia){

        this.newsFeedsRepository.loadNewsFeedFromUrl(feedsEntityWithMedia, feedsEntityWithMedia.feedsEntity.getUrl(),
                new LoaderCallback() {
                    @Override
                    public void onSuccess(FeedsEntityWithMedia feedsEntityWithMedia) {
                        feedsEntityWithMediaMutableLiveData.setValue(feedsEntityWithMedia);
                    }

                    @Override
                    public void onFailure(String errorString) {
                        Log.e(NewsFeedDetailViewModel.class.getSimpleName(),"Error::"+errorString);
                    }
                });
    }

}
