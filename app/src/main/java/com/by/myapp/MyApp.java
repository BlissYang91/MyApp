package com.by.myapp;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

/**
 * @Author yangtianfu
 * @Date 2023/7/27 14:29
 * @Describe
 */
@HiltAndroidApp
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
