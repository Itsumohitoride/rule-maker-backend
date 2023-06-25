package com.techCamp.backend.components;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.Document;
import org.json.JSONArray;
import org.springframework.core.convert.converter.Converter;

public class JSONArrayReadConverter implements Converter<Document, JSONArray> {

    @Override
    public JSONArray convert(Document source) {
        Set<String> keys=source.keySet();
        JSONArray jsonArray=new JSONArray();
        for(String s:keys){
            List<Object> list = source.getList(s,Object.class);
            for(Object obj:list){
                Document docObject = (Document) obj;
                Map<String,Object> dataMap=(Map<String,Object>) docObject.get(docObject.keySet().toArray()[0]);
                jsonArray.put(dataMap); 
            }
        }
        return jsonArray;
    }
}
