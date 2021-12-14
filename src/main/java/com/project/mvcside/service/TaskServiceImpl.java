package com.project.mvcside.service;

import com.project.mvcside.model.TaskWsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${task.rest.url}")
    private String restUrl;

    @Override
    public List<TaskWsDto> findAll() {
        return new RestTemplateBuilder()
                .basicAuthentication("mary", "test123")
                .build()
                .exchange(restUrl, HttpMethod.GET,  null,
                        new ParameterizedTypeReference<List<TaskWsDto>>() {})
                .getBody();
    }

    @Override
    public void createTask(TaskWsDto taskWsDto, String username) {
        restTemplate.postForEntity(restUrl.concat("?username=").concat(username), taskWsDto, String.class);
    }

    @Override
    public TaskWsDto find(Integer id) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", id);
        return restTemplate.getForObject(restUrl.concat("/{id}/"), TaskWsDto.class, params);
    }

    @Override
    public void update(TaskWsDto taskWsDto) {
        restTemplate.put(restUrl, taskWsDto);
    }
}
