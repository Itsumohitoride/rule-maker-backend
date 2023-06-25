package com.techCamp.backend.components;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.core.convert.converter.Converter;

public class JSONArrayReadConverter implements Converter<Document, JSONArray> {

    @Override
    public JSONArray convert(Document source) {
        System.out.println("************************************");
        Set<String> keys=source.keySet();
        JSONArray jsonArray=new JSONArray();
        for(String s:keys){
            List<Object> list = source.getList(s,Object.class);
            for(Object obj:list){
                JSONObject jsonObject = new JSONObject(obj);
                jsonArray.put(jsonObject);
            }
            
        }
        System.out.println(jsonArray.get(0));
        System.out.println("************************************");
        return jsonArray; // Devuelve el JSONArray deserializado
    }
}
