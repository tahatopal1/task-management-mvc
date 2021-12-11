package com.project.mvcside.service;

import com.project.mvcside.model.Task;
import com.project.mvcside.model.User;

import java.util.List;

public interface CustomerService {

    List<User> findAll();

    void addTaskToUser(String username, Task task);

}
