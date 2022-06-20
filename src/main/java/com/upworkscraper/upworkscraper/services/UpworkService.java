package com.upworkscraper.upworkscraper.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upworkscraper.upworkscraper.configuration.HttpClient;
import com.upworkscraper.upworkscraper.helpers.HttpConstants;
import com.upworkscraper.upworkscraper.models.UWResponse;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

import static com.upworkscraper.upworkscraper.helpers.HttpConstants.*;

@Service
public class UpworkService {

    public static final String URL = "https://www.upwork.com";
    public static final String RECOMMENDATION_SLUG = "/ab/find-work/api/feeds/embeddings-recommendations";

    final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void test() {
        System.out.println("time -> " + new Date());
    }

    public void handleUpworkRequest() {

        // TODO: Get this from DB
        String cookie = "";

        var response = sendRequest(cookie);

        UWResponse uwResponse = getUWResponseFromHttpResponse(response);
        System.out.println(uwResponse);
    }

    private Response sendRequest(String cookie) {

        var client = HttpClient.getClient();

        var request = new Request.Builder()
                .url(URL + RECOMMENDATION_SLUG)
                .method(HttpConstants.GET, null)
                .addHeader(ACCEPT_HEADER_KEY, ACCEPT_HEADER_VALUE)
                .addHeader(REQUESTED_WITH_HEADER_KEY, REQUESTED_WITH_HEADER_VALUE)
                .addHeader(COOKIE_HEADER_KEY, cookie)
                .build();

        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private UWResponse getUWResponseFromHttpResponse(Response response) {

        if (response.body() == null) {
            return null;
        }

        try {
            String json = response.body().string();
            return objectMapper.readValue(json, UWResponse.class);
        } catch (IOException e) {
            // TODO: Handle this
            e.printStackTrace();
        }
        return null;
    }
}
