package com.techCamp.backend.dto;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import lombok.Getter;

@Getter
public class CreateTableDTO {
    private String title;
    private String groupId;
    private List<Map<String, Object>> data;

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
