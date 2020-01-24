package com.arun.project.microservice.prjmicroserviceb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class RestClient {
    private final static RestClient INSTANCE = new RestClient();
    @Autowired
    private WebClient.Builder builder;
    @Autowired
    private RestTemplate restTemplate;

    private RestClient() {
    }

    public static RestClient getInstance() {
        return INSTANCE;
    }

    public String get(String url) {
        if (Objects.isNull(builder)) builder = WebClient.builder();
        Object block = builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        return block.toString();
    }
}
