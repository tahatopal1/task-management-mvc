package com.project.mvcside.model.wsdto;


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

    public UserWsDto getUserWsDto() {
        return userWsDto;
    }

    public void setUserWsDto(UserWsDto userWsDto) {
        this.userWsDto = userWsDto;
    }
}
