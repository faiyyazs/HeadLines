package com.headlines.ui;

import android.os.Bundle;

import com.headlines.utility.FragmentTransactionsUtil;
import com.headlines.viewmodel.ViewModelProviderFactory;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class BaseActivity<V extends ViewModel, D extends ViewDataBinding> extends AppCompatActivity {




    protected void loadFragment(Fragment fragment,
                                int containerId,
                                int transactionType,
                                boolean additToBackstack,
                                AppCompatActivity context){
        FragmentTransactionsUtil.loadFragment(fragment,
                containerId,
                transactionType,
                additToBackstack,context,null);

    }



    protected V viewModel;

    protected D dataBinding;

    protected abstract ViewModelProviderFactory getViewModelFactory();

    protected abstract Class<V> getViewModel();

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, getViewModelFactory()).get(getViewModel());
        dataBinding = DataBindingUtil.setContentView(this,getLayoutRes());
    }




    protected abstract void loadContent();


}
