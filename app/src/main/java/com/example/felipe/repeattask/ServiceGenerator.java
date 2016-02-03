package com.example.felipe.repeattask;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class ServiceGenerator {

    private ServiceGenerator() {

    }

    public static <S> S createService(Class<S> serviceClass) {

        String baseUrl = "https://api.github.com";
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setClient(new OkClient(new OkHttpClient()));
        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);

    }

}