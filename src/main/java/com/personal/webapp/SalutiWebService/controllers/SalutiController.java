package com.personal.webapp.SalutiWebService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/saluti")
public class SalutiController {

    @GetMapping(path = "/test")
    public String retrieveSaluti(){
        return "Hello there, just starting from point 0 once again :)";
    }
}
