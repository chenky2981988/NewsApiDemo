package com.sample.newsapi.ui.country;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;

import android.view.View;

import com.sample.newsapi.BR;
import com.sample.newsapi.R;
import com.sample.newsapi.ViewModelProviderFactory;
import com.sample.newsapi.databinding.ActivitySelectCountryBinding;
import com.sample.newsapi.ui.base.BaseActivity;
import com.sample.newsapi.ui.base.BaseViewModel;

import javax.inject.Inject;

public class SelectCountryActivity extends BaseActivity<ActivitySelectCountryBinding, SelectCountryViewModel> implements SelectCountryNavigator {

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;
    private SelectCountryViewModel selectCountryViewModel;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_select_country;
    }

    @Override
    public SelectCountryViewModel getViewModel() {
        selectCountryViewModel = ViewModelProviders.of(this,viewModelProviderFactory).get(SelectCountryViewModel.class);
        return selectCountryViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectCountryViewModel.setNavigator(this);
        setSupportActionBar(toolbar);

    }

    @Override
    public void goToMainActivity() {

    }
}
