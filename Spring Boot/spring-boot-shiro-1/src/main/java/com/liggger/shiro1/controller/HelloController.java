package com.liggger.shiro1.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
public class HelloController {
    @GetMapping("/login")
    public String login() {
        return "please login";
    }

    @PostMapping("/doLogin")
    public void doLogin(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("success");
        } finally {
            System.out.println("Finish");
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello shiro!";
    }
}
