package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.services.DescriptionService;
import com.talentpath.airTNB.models.Description;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/description")
public class DescriptionController {
    
    @Autowired
    DescriptionService DescriptionService;

    @GetMapping("/{id}")
    public Optional<Description> getDescription(@PathVariable Integer id) {
        return DescriptionService.getDescription(id);
    }
    @PostMapping("/add")
    public Description addDescription(@RequestBody Description newDesc){
        return DescriptionService.addDescription(newDesc);
    }
}
