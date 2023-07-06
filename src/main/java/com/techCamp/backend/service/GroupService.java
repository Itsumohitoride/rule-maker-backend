package com.techCamp.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techCamp.backend.dto.GroupDTO;
import com.techCamp.backend.dto.RoleMemberDTO;
import com.techCamp.backend.model.Group;
import com.techCamp.backend.model.UserGroup;
import com.techCamp.backend.repository.GroupRepository;

@Service
public class GroupService {
    
    @Autowired
    GroupRepository groupRepository;

    public List<Group> getAll(){
        return groupRepository.findAll();
    }

    public Group getOne(String id){
        return groupRepository.findById(id);
    }

    public Group save(GroupDTO dto){
        Group groupToSave = new Group(dto.getId(),dto.getDescription(),dto.getName());
        return groupRepository.save(groupToSave);
    }

    public Group update(String id,GroupDTO dto){
        Group group = groupRepository.findById(id);
        group.setName(dto.getName());
        group.setDescription(dto.getDescription());
        return groupRepository.save(group);
    }

    public Group delete(String id){
        Group groupToDelete=groupRepository.findById(id);
        return groupRepository.delete(groupToDelete);
    }

    public Group addMember(RoleMemberDTO dto){
        Group group = groupRepository.findById(dto.getGroupId());
        group.addMember(dto.getEmail(),dto.getRole());
        groupRepository.addMember(dto.getEmail(), dto.getGroupId());
        return groupRepository.save(group);
    }

    public List<UserGroup> getGroupsOf(String userId){
        return groupRepository.getGroupsOf(userId);
    }

    public Group changeUserRole(RoleMemberDTO dto){
        Group group = groupRepository.findById(dto.getGroupId());
        group.changeRole(dto.getEmail(),dto.getRole());
        return groupRepository.save(group);
    }

}
