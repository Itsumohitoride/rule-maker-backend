package com.techCamp.backend.components;

import java.io.IOException;

import org.json.JSONArray;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

@JsonComponent
@Component
public class JSONArrayDeserializer extends StdDeserializer<JSONArray> {
    
    public JSONArrayDeserializer() { 
        this(null); 
    } 

    public JSONArrayDeserializer(Class<?> vc) { 
        super(vc); 
    }

    @Override
    public JSONArray deserialize(com.fasterxml.jackson.core.JsonParser p, DeserializationContext ctxt)
            throws IOException, JacksonException {
        System.out.println("**********************************************************************");
        
        String json = p.getText();
        return new JSONArray(json);
    }
}