package com.project.mvcside.service;

import com.project.mvcside.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${task.rest.url}")
    private String restUrl;

    @Override
    public List<Task> findAll() {
        return restTemplate.exchange(restUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Task>>() {})
                .getBody();
    }
}
