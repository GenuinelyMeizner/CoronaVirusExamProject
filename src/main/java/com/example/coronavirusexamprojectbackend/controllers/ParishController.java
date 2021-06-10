package com.example.coronavirusexamprojectbackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParishController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }
}
