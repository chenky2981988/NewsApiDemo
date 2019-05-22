package com.sample.newsapi.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Chirag Sidhiwala on 5/22/2019.
 * chirag.sidhiwala@hotmail.com
 */
public interface SchedulerProvider {
    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
