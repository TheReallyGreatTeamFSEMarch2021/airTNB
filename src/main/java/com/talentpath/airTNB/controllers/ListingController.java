package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.InvalidIdException;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Host;
import com.talentpath.airTNB.models.Listing;
import com.talentpath.airTNB.models.Test;
import com.talentpath.airTNB.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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

    @GetMapping("/getListingsByCityAndState/{listingId}")
    public List<Listing> getListingsByCityAndState(@PathVariable Integer listingId) throws NullListingException {
        return listingService.getListingsByCityAndState(listingId);
    }

    @GetMapping("/getListingsCloseByLatAndLong/{listingId}")
    public List<Listing> getByLatAndLong(@PathVariable Integer listingId)throws NullListingException{
        return listingService.getListingsByLatAndLong(listingId);
    }

    @GetMapping("/getHost/{listingId}")
    public Host getHostByListingId(@PathVariable Integer listingId) throws InvalidIdException {
        return listingService.getHostByListingId(listingId);
    }
}
