package com.sample.newsapi.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.sample.newsapi.utils.NetworkUtils;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import butterknife.ButterKnife;

/**
 * Created by Chirag Sidhiwala on 5/20/2019.
 * chirag.sidhiwala@hotmail.com
 */
public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    // TODO
    // this can probably depend on isLoading variable of BaseViewModel,
    // since its going to be common for all the activities
    private ProgressDialog mProgressDialog;
    private T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    @LayoutRes
    protected abstract int layoutRes();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

//    @Override
//    public void onFragmentAttached() {
//
//    }
//
//    @Override
//    public void onFragmentDetached(String tag) {
//
//    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutRes());
        ButterKnife.bind(this);
        performDataBinding();
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, layoutRes());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }
}
