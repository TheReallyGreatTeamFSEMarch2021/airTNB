package com.talentpath.airTNB.services;

import com.talentpath.airTNB.models.Amenity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class AmenityServiceTest {
    @Autowired
    AmenityService amenityServ;

    @Autowired
    ListingService listingServ;

    @Test
    void getAllAmenity() {
        List<Amenity> amenities = amenityServ.getAllAmenity();
        assertEquals("hello",amenities.get(0).getValue());

    }


    @Test
    void getAmenity() {
        Amenity amenity = amenityServ.getAmenity(1);
        assertEquals("hello",amenity.getValue());
    }



    @Test
    void getAllByListing() {
        List<Amenity> amenities = amenityServ.getAllByListing(1);
        assertEquals("hello",amenities.get(0).getValue());
        assertEquals("Goodbye",amenities.get(1).getValue());
    }
}