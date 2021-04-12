package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.models.Test;
import com.talentpath.airTNB.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    TestService service;

    @GetMapping("/getAll")
    public List<Test> getAllTests() {
        return service.getAllTests();
    }

    @PostMapping("/add")
    public Test addQuestion(@RequestBody Test toAdd){return service.addTest(toAdd);}
}
