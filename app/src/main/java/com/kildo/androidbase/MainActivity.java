package com.kildo.androidbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kildo.core.Engine;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Engine engine = Engine.instance();
        engine.start();
    }
}