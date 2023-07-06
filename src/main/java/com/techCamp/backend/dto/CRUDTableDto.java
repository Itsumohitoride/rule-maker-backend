package com.techCamp.backend.dto;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.techCamp.backend.model.TableId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CRUDTableDto {
    private int tableId;
    private String groupId;
    private Map<String, Object> toUpdate = new HashMap<>();
    private String key;
    private String value;

    @JsonAnySetter
    public void setToUpdate(String key, Object value) {
        toUpdate.put(key, value);
    }
}
