package com.techCamp.backend.model;
import org.json.JSONArray;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tables")

public class Table {
    @Id
    private int id;

    private String title;

    private JSONArray data;

    public Table() {
    }

    public Table(int id, String title, JSONArray data) {
        this.id = id;
        this.title = title;
        this.data = data;
    }

    // Getters and setters

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    public JSONArray getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}