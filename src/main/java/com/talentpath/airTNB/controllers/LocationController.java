package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.models.LatLongRequest;
import com.talentpath.airTNB.models.Location;
import com.talentpath.airTNB.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    LocationService locationServ;

    @GetMapping("/getAll")
    public List<Location> getAllLocations(){
        return locationServ.getAllLocations();
    }

    @GetMapping("/getById/{id}")
    public Location getLocationById(@PathVariable Integer id) throws NullLocationException {
        return locationServ.getLocationById(id);
    }

    @PostMapping("/add/{listingId}")
    public Location addLocation(@RequestBody LatLongRequest latLongRequest, @PathVariable Integer listingId) throws NullLocationException {
        return locationServ.addLocation(latLongRequest, listingId);
    }




}
