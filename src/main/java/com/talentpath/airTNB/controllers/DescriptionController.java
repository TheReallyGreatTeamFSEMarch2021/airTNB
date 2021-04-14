package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.services.DescriptionService;
import com.talentpath.airTNB.models.Description;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping("/api/description")
public class DescriptionController {
    // Call service
    @Autowired
    DescriptionService DescriptionService;

    // This controller will return only one thing (Object with name)
    @GetMapping("/{id}")
    public Description getDescription(@PathVariable Integer id) {
        return DescriptionService.getDescription(id);
    }

    @GetMapping("/test/{id}")
    public Map<String,Integer> getTest(@PathVariable Integer id){
       return DescriptionService.testService(id);
    }
}
