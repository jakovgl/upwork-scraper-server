package com.upworkscraper.upworkscraper.configuration;

import okhttp3.OkHttpClient;

public class HttpClient {

    private static final OkHttpClient client = new OkHttpClient()
            .newBuilder()
            .build();

    private HttpClient() {

    }

    public static OkHttpClient getClient() {
        return client;
    }
}
