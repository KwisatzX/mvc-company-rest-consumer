package io.github.kwisatzx.mvccompanyrestconsumer;

import io.github.kwisatzx.mvccompanyrestconsumer.model.Employee;
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

    public List<Employee> getEmployeeList() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(URL_ROOT + "/employees",
                                                                        HttpMethod.GET, null,
                                                                        new ParameterizedTypeReference<>() {});
        return response.getBody();
    }
}
