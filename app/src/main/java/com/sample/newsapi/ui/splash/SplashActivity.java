package com.sample.newsapi.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.sample.newsapi.R;
import com.sample.newsapi.databinding.ActivitySplashScreenBinding;
import com.sample.newsapi.ui.base.BaseActivity;
import com.sample.newsapi.ui.main.MainActivity;

import androidx.lifecycle.ViewModelProviders;

public class SplashActivity extends BaseActivity<ActivitySplashScreenBinding, SplashViewModel> implements SplashNavigator {

    private SplashViewModel mSplashViewModel;

    @Override
    public int getBindingVariable() {
        return com.sample.newsapi.BR.viewModel;
    }

    @Override
    protected int layoutRes() {
        return R.layout.activity_splash_screen;
    }

    @Override
    public SplashViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        //ViewModelProvider.neof(this,factory).get(SplashViewModel.class);
        return mSplashViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.checkNetworkAvailable(isNetworkConnected());

    }

    @Override
    public void showErrorAlertDialog() {
        Toast.makeText(getApplicationContext(), "Show Alert !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openMainActivity() {

        // This method will be executed once the timer is over
        // Start your app main activity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

        // close this activity
        finish();
    }

    @Override
    public void finishActivity() {
        this.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mSplashViewModel.finishSplash();
    }
}
