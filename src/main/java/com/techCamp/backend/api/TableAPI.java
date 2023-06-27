package com.techCamp.backend.api;

import com.techCamp.backend.dto.RequestEvaluationDTO;
import com.techCamp.backend.dto.TableDto;
import com.techCamp.backend.model.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
public interface TableAPI {
    String BASE_TABLE_URL = "/table";

    @PostMapping
    Table save(@RequestBody TableDto dto);
    @GetMapping("/{id}")
    public Table getOne(@PathVariable("id") int id);
    @PutMapping("/{id}")
    public Table update(@PathVariable("id") int id,@RequestBody TableDto dto);
    @DeleteMapping("/{id}")
    public Table delete(@PathVariable("id") int id);
    @GetMapping("/evaluate")
    public String searchInBy(@RequestBody RequestEvaluationDTO evaluation);
    @GetMapping
    public List<Table> getAll();
}
