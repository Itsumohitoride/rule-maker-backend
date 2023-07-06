package com.techCamp.backend.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techCamp.backend.dto.RoleMemberDTO;
import com.techCamp.backend.dto.GroupDTO;
import com.techCamp.backend.model.Group;
import com.techCamp.backend.model.UserGroup;

@RequestMapping(GroupAPI.BASE_GROUP_URL)
public interface GroupAPI {
    String BASE_GROUP_URL = "/group";

    @PostMapping
    public Group save(@RequestBody GroupDTO dto);
    @PutMapping("/{id}")
    public Group update(@PathVariable String id,@RequestBody GroupDTO dto);
    @DeleteMapping("/{id}")
    public Group delete(@PathVariable String id);
    @GetMapping("/{id}")
    public Group getOne(@PathVariable String id);
    @GetMapping
    public List<Group> getAll();
    @PutMapping("/{id}/member")
    public Group addMember(@RequestBody RoleMemberDTO dto);
    @PutMapping("/{id}/member/role")
    public Group changeRoleToMemeber(@RequestBody RoleMemberDTO dto);
    @GetMapping("/Mygroups")
    public List<UserGroup> getGroupsOf(@RequestParam String userId);

}
