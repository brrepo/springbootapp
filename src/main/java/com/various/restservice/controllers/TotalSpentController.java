package com.various.restservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Acer on 23.08.2018.
 */
@RestController
public class TotalSpentController {
    @GetMapping("/totalspent")
    public String getTotalSpent(){
        return "Hello, world";
    }
}
