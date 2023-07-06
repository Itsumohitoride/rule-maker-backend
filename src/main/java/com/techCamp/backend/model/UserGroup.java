package com.techCamp.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userGroup")
public class UserGroup {
    private String userId;
    private String groupId;
}
