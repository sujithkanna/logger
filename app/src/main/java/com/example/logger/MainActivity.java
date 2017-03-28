package com.example.logger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hsalf.logger.Log;

import org.json.JSONException;
import org.json.JSONObject;

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
        // Log.i(TAG, "Just a text", new Throwable(), true);
        Log.v("My message");
        Log.v(null);
        Log.i(TAG, 12345);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("key", "hello world");
            Log.i(TAG, jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
