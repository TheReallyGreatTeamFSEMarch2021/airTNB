package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.AboutLocationRepository;
import com.talentpath.airTNB.daos.LocationRepository;
import com.talentpath.airTNB.exceptions.NullLocationException;
import com.talentpath.airTNB.models.AboutLocation;
import com.talentpath.airTNB.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutLocationService {
    @Autowired
    AboutLocationRepository aboutLocationRepo;

    @Autowired
    LocationRepository locationRepo;

    public List<AboutLocation> getLocationInfosByLocationId(Integer locationId){
        return aboutLocationRepo.findByLocationId(locationId);
    }

    public AboutLocation addLocationInfo(String toAddLocationInfo, Integer locationId) throws NullLocationException {
        Optional<Location> location = locationRepo.findById(locationId);
        AboutLocation aboutLocToAdd = new AboutLocation();
        if(location.isPresent()){
            aboutLocToAdd.setLocation(location.get());
            aboutLocToAdd.setLocationInfo(toAddLocationInfo);
            return aboutLocationRepo.saveAndFlush(aboutLocToAdd);
        }else{
            throw new NullLocationException("No location found with id: " + locationId);
        }

    }


}
