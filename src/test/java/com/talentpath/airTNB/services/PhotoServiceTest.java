package com.talentpath.airTNB.services;

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

    @BeforeEach
    @Transactional
    void setUp(){
        photoRepository.deleteAll();
        photoRepository.reset();
        Photo photo1 = new Photo();
        photo1.setId(1);
        photo1.setUrl("testurl1");

        Listing listing = new Listing();
        listing.setTitle("listing1");
        photo1.setListing(listing);
        photoRepository.saveAndFlush(photo1);
    }

    @Test
    @Transactional
    void getAllPhotos(){
        List<Photo> allPhotos = photoService.getAllPhotos();
        Photo photoToTest = allPhotos.get(0);
        assertNotNull(photoToTest);
        assertEquals(1,photoToTest.getId());
        assertEquals("testurl1", photoToTest.getUrl());
    }

    //using the 2 listings that are already in the test DB
    //will need to be updated if those test listings are removed
    @Test
    @Transactional
    void getPhotosByListingId(){
        Photo photo2 = new Photo();
        photo2.setId(2);
        photo2.setUrl("testurl2");

        Photo photo3 = new Photo();
        photo3.setId(3);
        photo3.setUrl("testurl3");

        try{
            photoService.attachListing(photo2, 5);
            photoService.attachListing(photo3, 6);

            photoRepository.saveAndFlush(photo2);
            photoRepository.saveAndFlush(photo3);

            List<Photo> photos5 = photoService.getByListingId(5);
            List<Photo> photos6 = photoService.getByListingId(6);

            assertEquals("testurl2", photos5.get(0).getUrl());
            assertEquals("testurl3", photos6.get(0).getUrl());

        }
        catch (NullListingException ex){
            fail("Failed to attach listing to photo");
        }

    }
}