package com.owen.androidlifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MainActivity", "crated");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity", "crated");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MainActivity", "paused");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.v("MainActivity", "resumed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", "stoped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", "destroyed");
    }
}
