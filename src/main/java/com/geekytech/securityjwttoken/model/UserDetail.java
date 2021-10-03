package com.geekytech.securityjwttoken.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table(name = "user")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String username;
    @Column
    String password;
    @Column
    String role;
}
