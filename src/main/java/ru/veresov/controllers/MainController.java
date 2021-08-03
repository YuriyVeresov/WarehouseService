package ru.veresov.controllers;

import org.springframework.web.bind.annotation.GetMapping;


public class MainController {

    @GetMapping("/apples")
    public String startPage(){
        return "index";
    }
}
