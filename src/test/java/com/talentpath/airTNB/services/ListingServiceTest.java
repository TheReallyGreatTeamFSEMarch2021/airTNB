package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.AmenityRepository;
import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.LocationRepository;
import com.talentpath.airTNB.models.Host;
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



    @BeforeEach
    void deleteAllItems(){
        listingRepo.deleteAll();
        listingRepo.reset();
    }

    @Test
    void getAllListings() {
        Listing list1 = new Listing("test title1","test subtitle1", null,null,null);
        Listing list2 = new Listing("test title2","test subtitle2",
                new Host(true,false,"a host for testing",null),null,null);
        Listing list3 = new Listing("test title3","test subtitle3", null,null,null);
    }

    @Test
    void getListingById() {
    }

    @Test
    void test(){
    }

}