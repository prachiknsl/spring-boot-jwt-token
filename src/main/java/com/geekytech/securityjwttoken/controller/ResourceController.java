package com.geekytech.securityjwttoken.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ResourceController {
    @RequestMapping("/user")
    public String getUsers(){
        log.info("Started User Controller");
        return "Hello User";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        log.info("Started Admin Controller");
        return "Hello Admin";
    }















}
