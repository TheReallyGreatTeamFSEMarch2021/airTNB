package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.services.DescriptionService;
import com.talentpath.airTNB.models.Description;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/description")
public class DescriptionController {
    // Call service
    @Autowired
    DescriptionService DescriptionService;

    // This will be removed at some point.
    @GetMapping("/test/{id}")
    public Map<String,Integer> getTest(@PathVariable Integer id){
        return DescriptionService.testService(id);
    }
    @GetMapping("/{id}")
    public Optional<Description> getDescription(@PathVariable Integer id) {
        return DescriptionService.getDescription(id);
    }
    @PostMapping("/add")
    public Description addDescription(@RequestBody Description newDesc){
        System.out.println(newDesc.toString());
        return DescriptionService.addDescription(newDesc);
    }
}
