package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Listing;
import com.talentpath.airTNB.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ListingService {
    @Autowired
    ListingRepository listingRepository;

    public List<Listing> getAllListings(){
        return listingRepository.findAll();
    }

    public Listing getListingById(Integer id) throws NullListingException {
        Optional<Listing> listing = listingRepository.findById(id);
        if(listing.isPresent()){
            return listing.get();
        }else{
            throw new NullListingException("No listing found with id: "+id);
        }
    }

    public Listing addListing(Listing toAdd) {
        return listingRepository.saveAndFlush(toAdd);
    }

    public List<Listing> getListingsByLatAndLong(Integer listingId) throws NullListingException {
        Optional<Listing> listing = listingRepository.findById(listingId);
        BigDecimal latitude, longitude;
        Location location;
        if(listing.isPresent()){
            location = listing.get().getLocation();
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            BigDecimal dist = new BigDecimal(.2);
            System.out.println(latitude.subtract(dist));
            System.out.println(longitude.subtract(dist));

            return listingRepository.findCloseLocationsByLatAndLong(latitude.subtract(dist), latitude.add(dist), longitude.subtract(dist), longitude.add(dist) );
        }else{
            throw new NullListingException("No listing exists with id: " + listingId);
        }
    }


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
}
