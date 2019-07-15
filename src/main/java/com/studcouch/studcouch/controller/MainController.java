package com.studcouch.studcouch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/")
public class MainController {

    @GetMapping("/")
    public String getAllPosts() {
        return "this is words from main page";
    }

}
