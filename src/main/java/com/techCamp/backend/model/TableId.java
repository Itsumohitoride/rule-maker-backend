package com.techCamp.backend.model;

public class TableId {
    private String groupId;
    private int tableId;

    public TableId(){

    }

    public TableId(int tableId,String groupId){
        this.groupId=groupId;
        this.tableId=tableId;
    }

    public String getGroupId(){
        return groupId;
    }

    public int getTableId(){
        return tableId;
    }

    @Override
    public boolean equals(Object other){
        TableId otherId=(TableId)other;
        if(this.groupId.equals(otherId.getGroupId())&&this.tableId==otherId.getTableId()){
            return true;
        }else return false;
    }

    @Override
    public int hashCode() {
        return tableId*groupId.hashCode();
    }
}
