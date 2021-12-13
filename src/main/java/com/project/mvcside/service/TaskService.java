package com.project.mvcside.service;

import com.project.mvcside.model.TaskWsDto;

import java.util.List;

public interface TaskService {

    List<TaskWsDto> findAll();

    void createTask(TaskWsDto taskWsDto, String username);

    TaskWsDto find(Integer id);

    void update(TaskWsDto taskWsDto);
}
