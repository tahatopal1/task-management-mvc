package com.project.mvcside.service;

import com.project.mvcside.model.TaskWsDto;
import com.project.mvcside.model.UserWsDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserWsDto> findAll();

    UserWsDto find();

    void addTaskToCustomer(String username, TaskWsDto taskWsDto);

}
