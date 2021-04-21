package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.models.AboutLocation;
import com.talentpath.airTNB.models.Location;
import com.talentpath.airTNB.services.AboutLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/aboutLocation")
public class AboutLocationController {
    @Autowired
    AboutLocationService aboutLocationServ;

    @GetMapping("/getByLocationId/{locationId}")
    public List<AboutLocation> getLocationInfosByLocationId(@PathVariable Integer locationId){
        return aboutLocationServ.getLocationInfosByLocationId(locationId);
    }

    @PostMapping("/add/{locationId}")
    public AboutLocation addLocationInfo(@RequestBody String locationInfo, @PathVariable Integer locationId) throws NullLocationException {
        return aboutLocationServ.addLocationInfo(locationInfo, locationId);
    }


}
