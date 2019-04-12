package com.headlines.viewmodel.factory;

import android.app.Application;

import com.headlines.repository.NewsFeedsRepository;
import com.headlines.viewmodel.NewsFeedDetailViewModel;
import com.headlines.viewmodel.ViewModelProviderFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

public class NewsFeedDetailViewVMFactory extends ViewModelProviderFactory {

    NewsFeedsRepository newsFeedsRepository;

    public NewsFeedDetailViewVMFactory(Application application, NewsFeedsRepository newsFeedsRepository){
        super(application);
        this.newsFeedsRepository = newsFeedsRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NewsFeedDetailViewModel(application,newsFeedsRepository);
    }
}
