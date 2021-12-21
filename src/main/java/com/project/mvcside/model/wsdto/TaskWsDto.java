package com.project.mvcside.model.wsdto;


import java.util.List;

public class TaskWsDto {

    private int id;
    private String title;
    private String definition;
    private UserWsDto userWsDto;
    private List<EntryWsDto> entryWsDtos;

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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public UserWsDto getUserWsDto() {
        return userWsDto;
    }

    public void setUserWsDto(UserWsDto userWsDto) {
        this.userWsDto = userWsDto;
    }

    public List<EntryWsDto> getEntryWsDtos() {
        return entryWsDtos;
    }

    public void setEntryWsDtos(List<EntryWsDto> entryWsDtos) {
        this.entryWsDtos = entryWsDtos;
    }
}
