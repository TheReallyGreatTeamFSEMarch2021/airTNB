package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.LocationRepository;
import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;


@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepo;


    public Location getLocationById(Integer id)throws NullLocationException {
        Optional<Location> location = locationRepo.findById(id);
        if(location.isPresent()) {
            return location.get();
        }else{
            throw new NullLocationException("No location found with location id provided: " + id);
        }
    };

    public Location addLocation(Location toAdd){
        return locationRepo.saveAndFlush(toAdd);
    }

    public List<Location> getAllLocations(){return locationRepo.findAll();}

}
