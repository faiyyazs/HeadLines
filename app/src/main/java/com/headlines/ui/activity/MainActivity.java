package com.headlines.ui.activity;

import android.os.Bundle;

import com.headlines.R;
import com.headlines.databinding.ActivityMainBinding;
import com.headlines.ui.BaseActivity;
import com.headlines.ui.fragments.NewsFeedListFragment;
import com.headlines.viewmodel.MainActivityViewModel;
import com.headlines.viewmodel.ViewModelProviderFactory;
import com.headlines.viewmodel.factory.MainActivityViewVMFactory;

public class MainActivity extends BaseActivity<MainActivityViewModel, ActivityMainBinding> {


    @Override
    protected ViewModelProviderFactory getViewModelFactory() {
        return new MainActivityViewVMFactory(getApplication());
    }

    @Override
    protected Class getViewModel() {
        return MainActivityViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadContent();
    }

    @Override
    protected void loadContent() {
        loadFragment(NewsFeedListFragment.newInstance(),R.id.fragment_container,
                0,false,this);
    }






}
