package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.PhotoRepository;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.models.Listing;
import com.talentpath.airTNB.models.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class PhotoServiceTest {

    @Autowired
    PhotoService photoService;
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    ListingRepository listingRepository;

    @BeforeEach
    @Transactional
    void setUp(){
        listingRepository.deleteAll();
        listingRepository.reset();
        photoRepository.deleteAll();
        photoRepository.reset();
    }

    @Test
    @Transactional
    void getAllPhotos(){
        Photo photo1 = new Photo();
        photo1.setId(1);
        photo1.setUrl("testurl1");
        Listing listing = new Listing();
        listing.setTitle("listing1");
        photo1.setListing(listing);
        photoRepository.saveAndFlush(photo1);

        List<Photo> allPhotos = photoService.getAllPhotos();
        Photo photoToTest = allPhotos.get(0);
        assertNotNull(photoToTest);
        assertEquals(1,photoToTest.getId());
        assertEquals("testurl1", photoToTest.getUrl());
    }

    @Test
    @Transactional
    void getPhotosByListingId(){
        Listing listing1 = new Listing();
        listing1.setTitle("listing1");
        Listing listing2 = new Listing();
        listing2.setTitle("listing2");
        listingRepository.saveAndFlush(listing1);
        listingRepository.saveAndFlush(listing2);

        Photo photo1 = new Photo();
        photo1.setId(2);
        photo1.setUrl("testurl2");
        Photo photo2 = new Photo();
        photo2.setId(3);
        photo2.setUrl("testurl3");

        try{
            photoService.attachListing(photo1, 1);
            photoService.attachListing(photo2, 2);
            photoRepository.saveAndFlush(photo1);
            photoRepository.saveAndFlush(photo2);

            List<Photo> photos1 = photoService.getByListingId(1);
            List<Photo> photos2 = photoService.getByListingId(2);

            assertEquals("testurl2", photos1.get(0).getUrl());
            assertEquals("testurl3", photos2.get(0).getUrl());
        }
        catch (NullListingException ex){
            fail("Failed to attach listing to photo");
        }
    }

}