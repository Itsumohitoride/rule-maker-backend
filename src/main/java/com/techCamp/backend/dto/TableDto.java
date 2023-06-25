package com.techCamp.backend.dto;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class TableDto {
    private String title;
    

    private List<Map<String, Object>> data;



    private TableDto(){

    }

    private TableDto(String title,List<Map<String, Object>> dataArray){	
        this.title=title;
        data=dataArray;
        
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }

    public JSONArray getData(){
        JSONArray jsonArray=new JSONArray();
        
        for (Map<String,Object> dataMap : data) {
            JSONObject jsonObject = new JSONObject(dataMap);
            jsonArray.put(jsonObject);
        }
        System.out.println(jsonArray.toString());
        return jsonArray;
    }

}
