package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Listing;
import com.talentpath.airTNB.models.Test;
import com.talentpath.airTNB.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/listing")
public class ListingController {

    @Autowired
    ListingService listingService;

    @GetMapping("/getAll")
    public List<Listing> getAllListings(){
        return listingService.getAllListings();
    }

    @GetMapping("/getById/{id}")
    public Listing getListingById(@PathVariable Integer id) throws NullListingException {
        return listingService.getListingById(id);
    }

    @PostMapping("/add")
    public Listing addListing(@RequestBody Listing toAdd){
        return listingService.addListing(toAdd);
    }
}
