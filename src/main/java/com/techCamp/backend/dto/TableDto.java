package com.techCamp.backend.dto;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.techCamp.backend.model.TableId;

@Getter
public class TableDto {
    private String title;
    private TableId id;
    private List<Map<String, Object>> data;

    public JSONArray getData(){
        JSONArray jsonArray=new JSONArray();
        
        for (Map<String,Object> dataMap : data) {
            JSONObject jsonObject = new JSONObject(dataMap);
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
