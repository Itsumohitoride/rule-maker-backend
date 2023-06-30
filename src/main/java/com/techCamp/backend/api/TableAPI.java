package com.techCamp.backend.api;

import com.techCamp.backend.dto.CreateTableDTO;
import com.techCamp.backend.dto.RequestEvaluationDTO;
import com.techCamp.backend.dto.TableDto;
import com.techCamp.backend.model.Table;
import com.techCamp.backend.model.TableId;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(TableAPI.BASE_TABLE_URL)
public interface TableAPI {
    String BASE_TABLE_URL = "/table";

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
}
