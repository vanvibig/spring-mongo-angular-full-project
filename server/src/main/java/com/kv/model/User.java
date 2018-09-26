package com.kv.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "user")
public class User {
    
    @Id
    private String id;

    private String email;

    private String password;

    private String fullname;

    private boolean enabled;

    @DBRef
    private Set<Role> roles;
}
