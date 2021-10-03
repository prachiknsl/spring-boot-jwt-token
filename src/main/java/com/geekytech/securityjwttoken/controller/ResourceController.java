package com.geekytech.securityjwttoken.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @RequestMapping("/user")
    public String getUsers(){
        System.out.println("Heyyy");
        return "Hello User";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Hello Admin";
    }















}
