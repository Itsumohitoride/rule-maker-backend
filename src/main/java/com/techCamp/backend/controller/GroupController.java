package com.techCamp.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.techCamp.backend.api.GroupAPI;
import com.techCamp.backend.dto.GroupDTO;
import com.techCamp.backend.dto.RoleMemberDTO;
import com.techCamp.backend.model.Group;
import com.techCamp.backend.model.UserGroup;
import com.techCamp.backend.service.GroupService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class GroupController implements GroupAPI {
    private final GroupService groupService;

    @Override
    public Group save(GroupDTO dto) {
        return groupService.save(dto);
    }

    @Override
    public Group update(String id, GroupDTO dto) {
        return groupService.update(id, dto);
    }

    @Override
    public Group delete(String id) {
        return groupService.delete(id);
    }

    @Override
    public Group getOne(String id) {
        return groupService.getOne(id);
    }

    @Override
    public List<Group> getAll() {
        return groupService.getAll();
    }

    @Override
    public Group addMember(RoleMemberDTO dto) {
        return groupService.addMember(dto);
    }

    @Override
    public Group changeRoleToMemeber(RoleMemberDTO dto) {
        return groupService.changeUserRole(dto);
    }

    @Override
    public List<UserGroup> getGroupsOf(String userId){
        return groupService.getGroupsOf(userId);
    }
}
