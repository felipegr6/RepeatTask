package com.example.felipe.repeattask;

import android.os.Handler;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RepeatTask implements Runnable {

    private Handler handler;

    private int count;
    private Map<Integer, String> mapUsers;

    public RepeatTask() {

        count = 0;
        mapUsers = new HashMap<>();
        handler = new Handler();

        mapUsers.put(0, "felipegr6");
        mapUsers.put(1, "jakewharton");
        mapUsers.put(2, "rafaeltoledo");

    }

    public void start() {
        handler.post(this);
    }

    @Override
    public void run() {

        ServiceGenerator.createService(EndPoints.class).getUser(mapUsers.get(count),
                new Callback<User>() {

                    @Override
                    public void success(User user, Response response) {
                        Log.w("Ok", user.toString());
                        increment();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e("Nok", error.getMessage() + " " + error.getUrl());
                        increment();
                    }

                });


    }

    private void increment() {

        count++;

        if (count == 3)
            count = 0;

        new Handler().postDelayed(this, 10000);

    }

    public void stop() {
        handler.removeCallbacksAndMessages(null);
    }

}