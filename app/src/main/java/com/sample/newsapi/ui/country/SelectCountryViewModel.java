package com.sample.newsapi.ui.country;

import com.sample.newsapi.data.DataManager;
import com.sample.newsapi.ui.base.BaseViewModel;
import com.sample.newsapi.utils.rx.SchedulerProvider;

/**
 * Created by Chirag Sidhiwala on 5/22/2019.
 * chirag.sidhiwala@hotmail.com
 */
public class SelectCountryViewModel extends BaseViewModel<SelectCountryNavigator> {

    public SelectCountryViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


}
