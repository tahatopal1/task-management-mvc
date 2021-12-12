package com.project.mvcside.service;

import com.project.mvcside.model.TaskWsDto;
import com.project.mvcside.model.UserWsDto;

import java.util.List;

public interface UserService {

    List<UserWsDto> findAll();

    void addTaskToCustomer(String username, TaskWsDto taskWsDto);

}
