package com.geekytech.securityjwttoken.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class UserDTO {
    String username;
    String password;
    String role;
}
