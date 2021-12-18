package com.project.mvcside.service;

import com.project.mvcside.model.BasicAuth;
import com.project.mvcside.model.wsdto.TaskWsDto;

import java.util.List;

public interface TaskService {

    List<TaskWsDto> findAll(BasicAuth auth);

    void createTask(TaskWsDto taskWsDto, Integer id);

    TaskWsDto find(Integer id);

    void update(TaskWsDto taskWsDto);
}
