package com.techCamp.backend.api;

import com.techCamp.backend.dto.RuleDto;
import com.techCamp.backend.model.Rule;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(RuleAPI.BASE_RULE_URL)
public interface RuleAPI {
    String BASE_RULE_URL = "/rule";

    @PostMapping("/create")
    public Rule save(@RequestBody RuleDto dto);
    @PutMapping("/{id}")
    public Rule update(@PathVariable int id,@RequestBody RuleDto dto);
    @DeleteMapping("/{id}")
    public Rule delete(@PathVariable int id);
    @GetMapping("/{id}")
    public Rule getOne(@PathVariable int id);
    @GetMapping("/getAll")
    public List<Rule> getAll();
}
