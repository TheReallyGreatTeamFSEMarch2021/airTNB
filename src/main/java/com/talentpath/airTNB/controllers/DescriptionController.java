package com.talentpath.airTNB.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/description")
public class DescriptionController {
    @GetMapping("/test")
    public String test() {
        return "TEST";
    }
}
