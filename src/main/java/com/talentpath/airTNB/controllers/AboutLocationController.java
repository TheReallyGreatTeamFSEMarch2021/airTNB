package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.daos.AboutLocationRepository;
import com.talentpath.airTNB.models.AboutLocation;
import com.talentpath.airTNB.services.AboutLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/aboutLocation")
public class AboutLocationController {
    @Autowired
    AboutLocationService aboutLocationServ;

    @Autowired
    AboutLocationRepository aboutLocationRepo;

    @GetMapping("/getByLocation/{locationId}")
    public List<AboutLocation> getByLocationId(@PathVariable Integer locationId){
        return aboutLocationServ.getAboutLocationsByLocationId(locationId);
    }

    @GetMapping("/getById/{id}")
    public AboutLocation getById(@PathVariable Integer id){
        return aboutLocationServ.getAboutLocationById(id);
    }

    @PostMapping("/")
    public AboutLocation addAboutLocation(@RequestBody AboutLocation newAboutLoc ){
        return aboutLocationRepo.saveAndFlush(newAboutLoc);
    }

}
