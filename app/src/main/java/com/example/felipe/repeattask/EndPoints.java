package com.example.felipe.repeattask;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface EndPoints {

    @GET("/users/{user}")
    void getUser(@Path("user") String user, Callback<User> userCallback);

}