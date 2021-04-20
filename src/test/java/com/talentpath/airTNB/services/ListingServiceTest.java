package com.talentpath.airTNB.services;

import com.talentpath.airTNB.models.Listing;
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
    ListingService listingServ;

    @Test
    void getAllListings() {
    }

    @Test
    void getListingById() {
    }

    @Test
    void addListing() {
        Listing listing = new Listing();
        listing.setTitle("house");
        listingServ.addListing(listing);
    }


}