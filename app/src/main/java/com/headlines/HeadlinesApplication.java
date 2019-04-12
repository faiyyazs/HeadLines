package com.headlines;

import android.app.Application;

import com.headlines.data.ApplicationDatabase;

public class HeadlinesApplication extends Application {


    private ApplicationDatabase applicationDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationDatabase = ApplicationDatabase.getInstance(this);
    }

    public ApplicationDatabase getApplicationDatabase(){
        return applicationDatabase;
    }
}
