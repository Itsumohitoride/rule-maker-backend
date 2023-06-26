package com.techCamp.backend.components;

import org.json.JSONObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.bson.Document;

@ReadingConverter
public class JSONObjectReadConverter implements Converter<Document, JSONObject> {

    @Override
    public JSONObject convert(Document source) {
        return new JSONObject(source.toJson());
    }
}