package com.kildo.androidbase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kildo.core.Engine;
import com.kildo.core.logger.Logger;
import com.kildo.core.logger.LoggerFactory;

public class MainActivity extends AppCompatActivity {

    private final static Logger LOGGER = LoggerFactory.getLogger(MainActivity.class, Constants.TAG);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        LOGGER.i("Engine start");

        Engine engine = Engine.instance();
        engine.start();
    }

    @Override
    protected void onDestroy() {

        LOGGER.i("Engine stop");

        Engine engine = Engine.instance();
        engine.stop();

        super.onDestroy();
    }
}