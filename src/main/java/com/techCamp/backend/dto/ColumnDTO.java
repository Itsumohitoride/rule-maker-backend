package com.techCamp.backend.dto;

import com.techCamp.backend.model.TableId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ColumnDTO {
    private TableId tableId;
    private String name;
    private String type;
}
