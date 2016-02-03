package com.example.felipe.repeattask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RepeatTask repeatTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repeatTask = new RepeatTask();

    }

    @Override
    protected void onResume() {
        super.onResume();
        repeatTask.start();
    }

    @Override
    protected void onStop() {
        repeatTask.stop();
        super.onStop();
    }

}