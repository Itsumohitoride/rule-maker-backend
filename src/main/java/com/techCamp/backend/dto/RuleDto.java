package com.techCamp.backend.dto;

public class RuleDto {
    private String name;
    private String rule;

    public RuleDto(){

    }
    public RuleDto(String name,String rule){
        this.name=name;
        this.rule=rule;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setRule(String rule){
        this.rule=rule;
    }

    public String getName(){
        return name;
    }

    public String getRule(){
        return rule;
    }
}
