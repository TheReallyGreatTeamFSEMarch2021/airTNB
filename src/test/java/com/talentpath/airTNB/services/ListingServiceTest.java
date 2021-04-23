package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.AmenityRepository;
import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.LocationRepository;
import com.talentpath.airTNB.models.Listing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ListingServiceTest {

    @Autowired
    ListingService listingServ; //the service that we are testing

    @Autowired
    ListingRepository listingRepo;
    @Autowired
    AmenityRepository amenityRepo;


    @BeforeEach
    void deleteAllItems(){
        amenityRepo.deleteAll();
        listingRepo.deleteAll();
    }

    @Test
    void getAllListings() {
    }

    @Test
    void getListingById() {
    }

    @Test
    void test(){
    }

}