package com.project.mvcside.service;

import com.project.mvcside.model.Task;
import com.project.mvcside.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${users.rest.url}")
    private String restUrl;

    @Override
    public List<User> findAll() {
        return restTemplate
                .exchange(restUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {})
                .getBody();
    }

    @Override
    public void addTaskToUser(String username, Task task) {

    }
}
