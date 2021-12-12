package com.project.mvcside.model;


public class TaskWsDto {

    private int id;
    private String title;
    private UserWsDto userWsDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserWsDto getUser() {
        return userWsDto;
    }

    public void setUser(UserWsDto userWsDto) {
        this.userWsDto = userWsDto;
    }
}
