package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.CityAndStateRequest;
import com.talentpath.airTNB.models.Listing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
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


//    public List<Listing> getListingsByCityAndState(CityAndStateRequest cityAndStateReq) {
//        String city = cityAndStateReq.getCity();
//        String state = cityAndStateReq.getState();
//        return listingRepository.findByCityIgnoreCaseAndStateIgnoreCase(city, state);
//    }

    public List<Listing> getListingsByCityAndState(Integer listingId) throws NullListingException {
        Optional<Listing> listing = listingRepository.findById(listingId);
        String city, state;
        if(listing.isPresent()){

            return listingRepository.findByCityIgnoreCaseAndStateIgnoreCase(listing.get().getCity(), listing.get().getState());
        }else{
            throw new NullListingException("No listing exists with id: " + listingId);
        }
//        String city = cityAndStateReq.getCity();
//        String state = cityAndStateReq.getState();

    }
}
