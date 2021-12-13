package com.project.mvcside.model;

import java.util.List;

public class UserWsDto {

    private String username;
    private String password;
    private Integer enabled;
    private List<TaskWsDto> taskWsDtos;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<TaskWsDto> getTaskWsDtos() {
        return taskWsDtos;
    }

    public void setTaskWsDtos(List<TaskWsDto> taskWsDtos) {
        this.taskWsDtos = taskWsDtos;
    }
}
