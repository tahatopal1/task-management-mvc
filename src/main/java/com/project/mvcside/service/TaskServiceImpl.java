package com.project.mvcside.service;

import com.project.mvcside.model.BasicAuth;
import com.project.mvcside.model.wsdto.TaskWsDto;
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
    public List<TaskWsDto> findAll(BasicAuth auth) {
        return new RestTemplateBuilder()
                .basicAuthentication(auth.getUsername(), auth.getPassword())
                .build()
                .exchange(restUrl, HttpMethod.GET,  null,
                        new ParameterizedTypeReference<List<TaskWsDto>>() {})
                .getBody();
    }

    @Override
    public void createTask(TaskWsDto taskWsDto, Integer id) {
        restTemplate.postForEntity(restUrl.concat("?id=") + id, taskWsDto, TaskWsDto.class);
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

    @Override
    public void delete(Integer task_id) {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", task_id);
        restTemplate.delete(restUrl.concat("/{id}/"), params);
    }
}
