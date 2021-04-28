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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ListingServiceTest {

    @Autowired
    ListingService listingServ; //the service that we are testing

    @Autowired
    ListingRepository listingRepo;



    @BeforeEach
    @Transactional
    void deleteAllItems(){
        listingRepo.deleteAll();
        listingRepo.reset();
    }

    @Test
    @Transactional
    void getAllListingsGoldenPath() {
        //create new listings
        Listing list1 = new Listing("test title1","test subtitle1", null,null,null);
        listingRepo.saveAndFlush(list1);
        Listing list2 = new Listing("test title2","test subtitle2",
                new Host(true,false,"a host for testing2",null),null,null);
        listingRepo.saveAndFlush(list2);
        Listing list3 = new Listing("test title2","test subtitle2",
                new Host(true,false,"a host for testing3",null),null,null);
        listingRepo.saveAndFlush(list3);
        List<Listing> original = new ArrayList<>();
        original.add(list1);
        original.add(list2);
        original.add(list3);
        List<Listing>allListings = listingRepo.findAll();
        assertEquals(allListings.size(),3);

        allListings.sort(new Comparator<Listing>() {
            @Override
            public int compare(Listing o1, Listing o2) {
                return o1.getId()-o2.getId();
            }
        });
        allListings.forEach(listing -> System.out.println(listing.getId()));
        for (int i = 0; i < 3; i++) {
            assertEquals(original.get(i).getTitle(),allListings.get(i).getTitle());
            assertEquals(original.get(i).getSubTitle(),allListings.get(i).getSubTitle());
            assertEquals(original.get(i).getCancellationRefundPercentage(),allListings.get(i).getCancellationRefundPercentage());
            assertEquals(original.get(i).getFreeCancellationDays(),allListings.get(i).getFreeCancellationDays());
            assertEquals(original.get(i).getPaidCancellationDays(),allListings.get(i).getFreeCancellationDays());
            //assumed to be null at this point, could add more testing data for these
            assertEquals(original.get(i).getPhotos(),allListings.get(i).getPhotos());
            assertEquals(original.get(i).getReviews(),allListings.get(i).getReviews());
            assertEquals(original.get(i).getRooms(),allListings.get(i).getRooms());
            assertEquals(original.get(i).getRuleList(),allListings.get(i).getRuleList());
            assertEquals(original.get(i).getLocation(),allListings.get(i).getLocation());
            try{
                assertEquals(original.get(i).getHost().getHostEmail(),allListings.get(i).getHost().getHostEmail());
                assertEquals(original.get(i).getHost().getDescription(),allListings.get(i).getHost().getDescription());
            }catch( NullPointerException e){
                //not all listings have a host
            }
        }

    }

    @Test
    void getListingById() {
        Listing test = new Listing("test title2","test subtitle2",
                new Host(true,false,"a host for testing2",null),null,null);
        listingRepo.saveAndFlush(test);
        Listing retrieved =  listingRepo.findById(1).get();
        //only testing non object fields here, could add more testing data
        assertEquals(test.getTitle(),retrieved.getTitle());
        assertEquals(test.getPaidCancellationDays(),retrieved.getFreeCancellationDays());
        assertEquals(test.getCancellationRefundPercentage(),retrieved.getCancellationRefundPercentage());
        assertEquals(test.getSubTitle(),retrieved.getSubTitle());
        assertEquals(1,retrieved.getId());
    }


}