package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ActivityRepository;
import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.exceptions.NullActivityException;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Activity;
import com.talentpath.airTNB.models.Listing;
import com.talentpath.airTNB.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    ListingRepository listingRepository;

    @Autowired
    ActivityRepository repo;

    public List<Activity> getAllActivities(){return repo.findAll();}

    public List<Activity> getActivitiesByCity(String city){return repo.findByCity(city);}

    public Activity getActivityById(Integer id) throws NullActivityException {
        Optional<Activity> activity = repo.findById(id);
        if(activity.isPresent()){
            return activity.get();
        }else{
            throw new NullActivityException("No activity with id: " + id);
        }
    }

    public List<Activity> getActivitiesByCityAndState(Integer listingId) throws NullListingException {
        Optional<Listing> listing = listingRepository.findById(listingId);
        String city, state;
        if(listing.isPresent()){
            Location loc = listing.get().getLocation();
            return repo.findByCityContainsAndRegionContains(loc.getCity(), loc.getState());
        }else{
            throw new NullListingException("No listing exists with id: " + listingId);
        }
    }

        /*
        public List<Listing> getListingsByCityAndState(Integer listingId) throws NullListingException {
        Optional<Listing> listing = listingRepository.findById(listingId);
        String city, state;
        if(listing.isPresent()){
            Location loc = listing.get().getLocation();
            return listingRepository.findAllByLocationCityState(loc.getCity(), loc.getState());
        }else{
            throw new NullListingException("No listing exists with id: " + listingId);
        }
    }
         */
}
