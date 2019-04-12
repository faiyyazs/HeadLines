package com.headlines.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.headlines.R;
import com.headlines.data.entities.FeedsEntityWithMedia;
import com.headlines.databinding.FragmentNewsfeedlistBinding;
import com.headlines.databinding.LayoutItemNewsBinding;
import com.headlines.remote.Status;
import com.headlines.ui.BaseActivity;
import com.headlines.ui.BaseFragment;
import com.headlines.ui.adapter.NewsFeedsListAdapter;
import com.headlines.ui.callbacks.ListCallBack;
import com.headlines.utility.FragmentTransactionsUtil;
import com.headlines.utility.InjectorUtils;
import com.headlines.viewmodel.NewsFeedListViewModel;
import com.headlines.viewmodel.ViewModelProviderFactory;
import com.headlines.viewmodel.factory.NewsFeedListViewVMFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

public class NewsFeedListFragment extends BaseFragment<NewsFeedListViewModel, FragmentNewsfeedlistBinding> implements ListCallBack<LayoutItemNewsBinding> {


    public static NewsFeedListFragment newInstance() {

        Bundle args = new Bundle();

        NewsFeedListFragment fragment = new NewsFeedListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected ViewModelProviderFactory getViewModelFactory() {
        return new NewsFeedListViewVMFactory(getApplication(),
                InjectorUtils.provideFeedsRepository(getApplication().getApplicationDatabase()));
    }

    @Override
    protected Class<NewsFeedListViewModel> getViewModel() {
        return NewsFeedListViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_newsfeedlist;
    }

    @Override
    protected void loadContent() {

        viewModel.getMostPopularNewsFeeds().observe(this, listResource -> {

            if(null != listResource && (listResource.status == Status.ERROR || listResource.status == Status.SUCCESS)){
                dataBinding.refresh.setRefreshing(false);
            }else{
                dataBinding.refresh.setRefreshing(true);
            }
            dataBinding.setResource(listResource);

        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBinding.newsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataBinding.newsList.setAdapter(new NewsFeedsListAdapter(this));
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        loadContent();
        dataBinding.refresh.setOnRefreshListener(this::loadContent);

    }

    @Override
    public void onItemClick(FeedsEntityWithMedia entityWithMedia,LayoutItemNewsBinding dataBinding) {
        if(getActivity() != null && entityWithMedia != null){

            FragmentTransactionsUtil.loadFragment(
                    NewsInformationFragment.newInstance(entityWithMedia),
                    R.id.fragment_container,
                    0,true,
                    (BaseActivity) getActivity(),
                    null);

        }
    }
}
