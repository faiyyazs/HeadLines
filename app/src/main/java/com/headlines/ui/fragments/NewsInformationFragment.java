package com.headlines.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.headlines.R;
import com.headlines.data.converters.DateConverter;
import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.data.entities.MediaEntity;
import com.headlines.databinding.FragmentDetailsNewsfeedBinding;
import com.headlines.ui.BaseFragment;
import com.headlines.utility.Constants;
import com.headlines.utility.InjectorUtils;
import com.headlines.viewmodel.NewsFeedDetailViewModel;
import com.headlines.viewmodel.ViewModelProviderFactory;
import com.headlines.viewmodel.factory.NewsFeedDetailViewVMFactory;

import androidx.annotation.Nullable;

public class NewsInformationFragment extends BaseFragment<NewsFeedDetailViewModel, FragmentDetailsNewsfeedBinding> {


    private FeedsEntityWithMedia feedsEntityWithMedia = new FeedsEntityWithMedia();


    public static NewsInformationFragment newInstance(FeedsEntityWithMedia feedsEntityWithMedia) {
        
        Bundle args = new Bundle();
        args.putString(Constants.EXTRA_NEWSFEED_TITLE,feedsEntityWithMedia.feedsEntity.getTitle());
        args.putString(Constants.EXTRA_NEWSFEED_URL,feedsEntityWithMedia.feedsEntity.getUrl());
        args.putString(Constants.EXTRA_NEWSFEED_IMAGE_URL,feedsEntityWithMedia.mediaEntity.get(2).getUrl());
        args.putLong(Constants.EXTRA_NEWSFEED_UPDATED_DATE,feedsEntityWithMedia.feedsEntity.getLastUpdated().getTime());
        NewsInformationFragment fragment = new NewsInformationFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    
    @Override
    protected ViewModelProviderFactory getViewModelFactory() {
        return  new NewsFeedDetailViewVMFactory(getApplication(),
                InjectorUtils.provideFeedsRepository(getApplication().getApplicationDatabase()));
    }

    @Override
    protected Class getViewModel() {
        return NewsFeedDetailViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_details_newsfeed;
    }

    @Override
    protected void loadContent() {
        dataBinding.loading.setVisibility(View.VISIBLE);
        dataBinding.content.setVisibility(View.GONE);

        viewModel.loadFeedsInformation(feedsEntityWithMedia);

        viewModel.getFeedsEntityWithMediaMutableLiveData().observe(this, feedsEntityWithMediaResult -> {

            if(feedsEntityWithMediaResult != null) {
                dataBinding.loading.setVisibility(View.GONE);
                dataBinding.content.setVisibility(View.VISIBLE);
                dataBinding.setFeed(feedsEntityWithMediaResult);
                dataBinding.executePendingBindings();
            }
        });

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if(null != args) {
            feedsEntityWithMedia.feedsEntity.setTitle(args.getString(Constants.EXTRA_NEWSFEED_TITLE, ""));
            feedsEntityWithMedia.feedsEntity.setUrl(args.getString(Constants.EXTRA_NEWSFEED_URL, ""));
            feedsEntityWithMedia.feedsEntity.setLastUpdated(DateConverter.toDate(args.getLong(Constants.EXTRA_NEWSFEED_UPDATED_DATE, 0)));
            MediaEntity mediaEntity = new MediaEntity();
            mediaEntity.setUrl(args.getString(Constants.EXTRA_NEWSFEED_IMAGE_URL, ""));
            feedsEntityWithMedia.mediaEntity.add(mediaEntity);
            loadContent();
        }

    }





}
