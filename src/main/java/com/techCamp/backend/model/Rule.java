package com.techCamp.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class Rule {
    @Id
    private int id;
    private String name;
    private String rule;

    public Rule(){

    }

    public Rule(int id,String name,String rule){
        this.id=id;
        this.name=name;
        this.rule=rule;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setRule(String rule){
        this.rule=rule;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getRule(){
        return rule;
    }
    
}
