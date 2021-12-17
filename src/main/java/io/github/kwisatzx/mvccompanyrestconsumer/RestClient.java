package io.github.kwisatzx.mvccompanyrestconsumer;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class RestClient {
    private final static String URL_ROOT = "http://localhost:8080/api";
    private final RestTemplate restTemplate;

    public RestClient() {
        restTemplate = new RestTemplateBuilder().build();
    }

    public <T> List<T> getList(Class<T> elementClass, String listUrl) {
        ResponseEntity<List<T>> response = restTemplate.exchange(URL_ROOT + listUrl,
                                                                        HttpMethod.GET, null,
                                                                        new ParameterizedTypeReference<>() {});
        return response.getBody();
    }

    public <T> T getObject(Class<T> clazz, String url) {
        return restTemplate.getForObject(URL_ROOT + url, clazz);
    }

    public void deleteObject(String url) {
        restTemplate.exchange(URL_ROOT + url, HttpMethod.DELETE, null, Object.class);
    }
}
