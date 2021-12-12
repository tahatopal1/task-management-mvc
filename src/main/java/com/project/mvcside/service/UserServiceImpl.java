package com.project.mvcside.service;

import com.project.mvcside.model.TaskWsDto;
import com.project.mvcside.model.UserWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${users.rest.url}")
    private String restUrl;

    @Override
    public List<UserWsDto> findAll() {
        return restTemplate
                .exchange(restUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserWsDto>>() {})
                .getBody();
    }

    @Override
    public void addTaskToCustomer(String username, TaskWsDto taskWsDto) {

    }
}
