package com.upworkscraper.upworkscraper.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.upworkscraper.upworkscraper.configuration.HttpClient;
import com.upworkscraper.upworkscraper.helpers.HttpConstants;
import com.upworkscraper.upworkscraper.helpers.Util;
import com.upworkscraper.upworkscraper.models.Job;
import com.upworkscraper.upworkscraper.models.UWResponse;
import lombok.RequiredArgsConstructor;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.upworkscraper.upworkscraper.helpers.HttpConstants.*;

@Service
@RequiredArgsConstructor
public class UpworkService {

    public Logger logger = LoggerFactory.getLogger(UpworkService.class);

    private final JobService jobService;

    public static final String URL = "https://www.upwork.com";
    public static final String RECOMMENDATION_SLUG = "/ab/find-work/api/feeds/embeddings-recommendations";

    final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public void handleUpworkRequest() {

        logger.info("Upwork request triggered");

        // TODO: Get this from DB
        String cookie = "";

        var response = sendRequest(cookie);

        UWResponse uwResponse = getUWResponseFromHttpResponse(response);

        if (Util.isListNullOrEmpty(uwResponse.getResults())) {
            return;
        }

        for (Job job : uwResponse.getResults()) {
            if (!jobService.isQualified(job)) {
                continue;
            }
            // TODO: Send notification
            // TODO: Persist the job
        }
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
            logger.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private UWResponse getUWResponseFromHttpResponse(Response response) {

        if (response.body() == null) {
            logger.debug("Response body is empty");
            return new UWResponse();
        }

        try {
            String json = response.body().string();

            var uwResponse = objectMapper.readValue(json, UWResponse.class);
            logger.debug(uwResponse.toString());

            return uwResponse;

        } catch (IOException e) {
            // TODO: Handle this
            logger.error(e.getMessage());
        }
        return new UWResponse();
    }
}
