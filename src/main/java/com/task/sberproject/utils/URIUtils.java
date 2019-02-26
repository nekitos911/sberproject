package com.task.sberproject.utils;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class URIUtils {
    private final RestTemplate restTemplate;

    public URIUtils(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public <T> T invoke(URI url, Class<T> responseType) {
        ResponseEntity<T> exchange;
        RequestEntity<?> request;
        request = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON).build();
        exchange = this.restTemplate
                .exchange(request, responseType);

        return exchange.getBody();
    }
}
