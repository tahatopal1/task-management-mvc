package com.project.mvcside.service;

import com.project.mvcside.model.wsdto.TaskWsDto;
import com.project.mvcside.model.wsdto.UserWsDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserWsDto> findAll();

    UserWsDto findByUsername(String username);

    void addTaskToCustomer(String username, TaskWsDto taskWsDto);

}
