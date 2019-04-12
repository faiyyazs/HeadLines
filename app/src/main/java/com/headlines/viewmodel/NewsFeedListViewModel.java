package com.headlines.viewmodel;

import android.app.Application;

import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.remote.Resource;
import com.headlines.repository.NewsFeedsRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class NewsFeedListViewModel extends ViewModel {

    private NewsFeedsRepository newsFeedsRepository;


    public NewsFeedListViewModel(@NonNull Application application, NewsFeedsRepository newsFeedsRepository) {
        this.newsFeedsRepository = newsFeedsRepository;
    }

    public LiveData<Resource<List<FeedsEntityWithMedia>>> getMostPopularNewsFeeds() {
        return newsFeedsRepository.loadMostPopularFeeds();
    }

}
