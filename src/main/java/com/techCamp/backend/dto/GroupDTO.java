package com.techCamp.backend.dto;

import java.util.HashMap;

import lombok.Getter;

@Getter
public class GroupDTO {

    private String groupId;
    private HashMap<String,String> members;
    private String description;
    private String name;

    public GroupDTO(){
        members=new HashMap<>();
    }

    public GroupDTO(String groupId,String description,String name){
        this.groupId=groupId;
        this.description=description;
        this.name=name;
        members=new HashMap<>();
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return description;
    }

    public String getId(){
        return groupId;
    }

    public String getName(){
        return name;
    }

    public HashMap<String,String> getMembers(){
        return members;
    }

    public void setMembers(HashMap<String,String> members){
        this.members=members;
    }

}
