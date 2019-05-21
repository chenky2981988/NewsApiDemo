package com.sample.newsapi.ui.base;

import java.lang.ref.WeakReference;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

/**
 * Created by Chirag Sidhiwala on 5/21/2019.
 * chirag.sidhiwala@hotmail.com
 */
public abstract class BaseViewModel<N> extends ViewModel {

    private final ObservableBoolean mIsLoading = new ObservableBoolean();
    private WeakReference<N> mNavigator;

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

}
