package com.geekytech.securityjwttoken.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UserDTO {
    private String username;
    private String password;
    private String role;
}
