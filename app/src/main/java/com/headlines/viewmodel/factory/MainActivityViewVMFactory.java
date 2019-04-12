package com.headlines.viewmodel.factory;

import android.app.Application;

import com.headlines.viewmodel.MainActivityViewModel;
import com.headlines.viewmodel.ViewModelProviderFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

public class MainActivityViewVMFactory extends ViewModelProviderFactory {


    public MainActivityViewVMFactory(@NonNull Application application) {
        super(application);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainActivityViewModel(application);
    }
}
