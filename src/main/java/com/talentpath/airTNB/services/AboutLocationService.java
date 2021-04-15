package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.AboutLocationRepository;
import com.talentpath.airTNB.models.AboutLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutLocationService {

    @Autowired
    AboutLocationRepository aboutLocationRepo;

    public List<AboutLocation> getAboutLocationsByLocationId(Integer locationId){
        return aboutLocationRepo.findByLocationId(locationId);
    }

    public AboutLocation getAboutLocationById(Integer id){
        Optional<AboutLocation> aboutLoc = aboutLocationRepo.findById(id);
        if(aboutLoc.isPresent()){
            return aboutLoc.get();
        }
        return null;
        //thought about throwing an NoSuchAboutLocationException,
        //but don't really think I'll end up using this method

    }




}
