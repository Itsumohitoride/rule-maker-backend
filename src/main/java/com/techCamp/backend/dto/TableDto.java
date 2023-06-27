package com.techCamp.backend.dto;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

@Getter
public class TableDto {
    private String title;
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
