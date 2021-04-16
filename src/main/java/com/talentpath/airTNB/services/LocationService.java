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

    public Location getById(Integer id) throws NullLocationException {
        Optional<Location> location = locationRepo.findById(id);
        if(location.isEmpty()){
            throw new NullLocationException("No location with id: " + id);
        }else{
            return location.get();
        }
    };



    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }
}
