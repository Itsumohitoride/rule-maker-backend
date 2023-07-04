package com.techCamp.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ColumnID {
    private TableId tableId;
    private String name;

    @Override
    public boolean equals(Object obj){
        ColumnID other=(ColumnID)obj;
        if(this.tableId.equals(other.tableId)&&this.name.equals(other.name)){
            return true;
        }else return false;
    }

    @Override
    public int hashCode(){
        return tableId.hashCode()*name.hashCode();
    }
}
