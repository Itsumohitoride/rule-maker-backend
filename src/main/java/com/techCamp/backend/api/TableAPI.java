package com.techCamp.backend.api;

import org.json.JSONObject;
import com.techCamp.backend.dto.CRUDTableDto;
import com.techCamp.backend.dto.ColumnDTO;
import com.techCamp.backend.dto.CreateTableDTO;
import com.techCamp.backend.dto.RequestEvaluationDTO;
import com.techCamp.backend.dto.TableDto;
import com.techCamp.backend.model.Column;
import com.techCamp.backend.model.ColumnID;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.model.TableId;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(TableAPI.BASE_TABLE_URL)
public interface TableAPI {
    final String BASE_TABLE_URL = "/table";
    final String BASE_COLUMN_URL="/column";

    @PostMapping
    Table save(@RequestBody CreateTableDTO dto);
    @GetMapping("/get")
    public Table getOne(@RequestBody TableId id);
    @PutMapping("/{id}")
    public Table update(@RequestBody TableDto dto);
    @DeleteMapping("/{id}")
    public Table delete(@RequestBody TableId id);
    @GetMapping("/evaluate")
    public String searchInBy(@RequestBody RequestEvaluationDTO evaluation);
    @GetMapping
    public List<Table> getAll();
    @PutMapping("/update")
    public JSONObject updateInBy(@RequestBody CRUDTableDto dto);
    @PostMapping("/create")
    public JSONObject pushInBy(@RequestBody CRUDTableDto dto);
    @DeleteMapping("/delete")
    public boolean removeInBy(@RequestBody CRUDTableDto dto);
    @PostMapping(BASE_COLUMN_URL+"/create")
    public Column save(@RequestBody ColumnDTO dto);
    @DeleteMapping(BASE_COLUMN_URL+"/delete")
    public Column delete(@RequestBody ColumnID dto);
    @GetMapping(BASE_COLUMN_URL)
    public Column get(@RequestBody ColumnID id);
    @GetMapping(BASE_COLUMN_URL+"s")
    public List<Column> get(@RequestBody TableId id);
}
