package com.example.logger;

import android.app.Application;

import com.hsalf.logger.Log;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    private static MyApplication sMyApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sMyApplication = this;
        Log.enableAutoNameDetection(Log.isDebuggable(this)); // Highly recommended
    }

    public static MyApplication getInstance() {
        return sMyApplication;
    }
}
