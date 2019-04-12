package com.headlines.viewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModelProvider;

public abstract class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    protected Application application;


    public ViewModelProviderFactory(Application application){
       this.application = application;
    }

}
