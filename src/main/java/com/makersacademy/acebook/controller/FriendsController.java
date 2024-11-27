package com.makersacademy.acebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FriendsController {
    @GetMapping("/friends")
    public String index(Model model) {
        return "friends/index";
    }
}