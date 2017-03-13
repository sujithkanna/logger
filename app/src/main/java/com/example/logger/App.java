package com.example.logger;

import android.app.Application;

import com.hsalf.logger.Log;

public class App extends Application {

    private static final String TAG = "App";

    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        Log.disableOnRelease(true);
    }

    public static App getInstance() {
        return sApp;
    }
}
