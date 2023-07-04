package com.techCamp.backend.model;

import java.util.HashMap;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "groups")
public class Group {
    @Id
    private String groupId;
    private HashMap<String,String> members;
    private String description;
    private String name;
    @Transient
    public final String DEFAULT_ROLE="USER";

    public Group(){
    }

    public Group(String id,String description,String name){
        this.groupId=id;
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

    public boolean addMember(String idUser){
        members.put(idUser,DEFAULT_ROLE);
        return true;
    }

    public boolean addMember(String idUser,String role){
        members.put(idUser,role);
        return true;
    }

    public boolean changeRole(String idUser,String newRole){
        members.put(idUser,newRole);
        return true;
    }

    public boolean isMember(String idUser){
        if(members.get(idUser)!=null){
            return true;
        }else return false;
    }

    public HashMap<String,String> getMembers(){
        return members;
    }

    public void setMembers(HashMap<String,String> members){
        this.members=members;
    }

}
