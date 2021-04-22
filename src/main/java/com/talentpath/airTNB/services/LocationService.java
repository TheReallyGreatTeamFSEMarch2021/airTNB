package com.talentpath.airTNB.services;


import com.talentpath.airTNB.controllers.ListingController;
import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.LocationRepository;
import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.models.LatLongRequest;
import com.talentpath.airTNB.models.Listing;
import com.talentpath.airTNB.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepo;


    @Autowired
    ListingRepository listingRepo;


    public Location getLocationById(Integer id)throws NullLocationException {
        Optional<Location> location = locationRepo.findById(id);
        if(location.isPresent()) {
            return location.get();
        }else{
            throw new NullLocationException("No location found with location id provided: " + id);
        }
    };


    public List<Location> getAllLocations(){return locationRepo.findAll();}

    public Location addLocation(LatLongRequest latLongRequest, Integer listingId) throws NullLocationException {
        Optional<Listing> listing = listingRepo.findById(listingId);
        Location toAddLocation = new Location();
        if(listing.isPresent()){
            toAddLocation.setListing(listing.get());
            toAddLocation.setLatitude(latLongRequest.getLatitude());
            toAddLocation.setLongitude(latLongRequest.getLongitude());
            return locationRepo.saveAndFlush(toAddLocation);
        }
        else{
            throw new NullLocationException("In LocationService, for method addLocation, no listing found with id: " + listingId);
        }
    }

}
