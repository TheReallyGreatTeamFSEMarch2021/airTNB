package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.models.Amenity;
import com.talentpath.airTNB.services.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/amenity")
public class AmenityController {

    @Autowired
    AmenityService amenityServ;

    @GetMapping("/getByListingId/{listingId}")
    public List<Amenity> getInfosByItemId(@PathVariable Integer listingId) {

        return amenityServ.getAllByListing(listingId);
    }

}
