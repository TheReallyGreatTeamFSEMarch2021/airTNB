package com.talentpath.airTNB.services;


import com.talentpath.airTNB.controllers.ListingController;
import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.LocationRepository;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.exceptions.NullLocationFieldException;
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

    public Location addLocation(Location toAddLocation) throws NullLocationException, NullLocationFieldException {
      if(toAddLocation==null){
          throw new NullLocationException("in LocationService, for addLocation(), locationToAdd object can't be null");
      }else if(toAddLocation.getCity()==null ||toAddLocation.getState()==null || toAddLocation.getLatitude() ==null || toAddLocation.getLongitude()==null){
          throw new NullLocationFieldException("City, State, Latitude, and Longitude fields cannot be null or blank!");
      }else{
          return locationRepo.saveAndFlush(toAddLocation);
      }
    }





}
