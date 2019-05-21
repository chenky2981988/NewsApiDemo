package com.sample.newsapi.ui.splash;

import android.os.Handler;

import com.sample.newsapi.ui.base.BaseViewModel;

/**
 * Created by Chirag Sidhiwala on 5/21/2019.
 * chirag.sidhiwala@hotmail.com
 */
public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    private static final int SPLASH_TIME_OUT = 3000;
    private Handler splashHandler = null;

    public void checkNetworkAvailable(boolean isNetworkAvailable) {
        if (isNetworkAvailable) {
            startSplashTimer();
        } else {
            finishSplash();
        }
    }

    private void startSplashTimer() {
        splashHandler = new Handler();
        splashHandler.postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                getNavigator().openMainActivity();
                splashHandler = null;
            }
        }, SPLASH_TIME_OUT);
    }

    public void finishSplash() {
        if (splashHandler != null) {
            splashHandler.removeCallbacksAndMessages(null);
        }
        getNavigator().finishActivity();
    }
}
