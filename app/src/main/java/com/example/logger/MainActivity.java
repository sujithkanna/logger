package com.example.logger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hsalf.logger.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "test hello log", true);
        myMethod();
    }

    public void myMethod() {
        Log.i(TAG, "Just a text", new Throwable(), true);
        Log.v("My message");
    }
}
