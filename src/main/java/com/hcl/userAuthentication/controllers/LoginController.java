package com.hcl.userAuthentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String showWelcome(ModelMap modelMap) {
        return "Welcome";
    }

    @GetMapping("/login")
    public String showLogin(ModelMap modelMap) {
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String username, @RequestParam String password) {
        //TODO

        return "success";
    }
}
