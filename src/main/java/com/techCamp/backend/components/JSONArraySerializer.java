package com.techCamp.backend.components;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.json.JSONArray;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Configuration
@Component
public class JSONArraySerializer extends StdSerializer<JSONArray>{

    public JSONArraySerializer() {
        this(null);
    }

    public JSONArraySerializer(Class<JSONArray> t) {
        super(t);
    }

    @Override
    public void serialize(JSONArray value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeRawValue(value.toString());
    }
}

