package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ListingRepository;
import com.talentpath.airTNB.daos.ReviewRepository;
import com.talentpath.airTNB.models.Listing;
import com.talentpath.airTNB.models.Review;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ReviewTest {

    @Autowired
    ReviewRepository reviewRepo;

    @Autowired
    ListingRepository listingRepo;

    @BeforeEach
    @Transactional
    void setup() {
        reviewRepo.deleteAll();
        reviewRepo.reset();
    }

    @Test
    @Transactional
    void getAllReviews(){
        List<Review> allReviews = reviewRepo.findAll();
        assertEquals(0, allReviews.size());

        Review review = new Review();
        reviewRepo.saveAndFlush(review);
        allReviews = reviewRepo.findAll();
        assertEquals(1, allReviews.size());
        assertEquals(1, allReviews.get(0).getId());
    }

    @Test
    @Transactional
    void getReviewById(){
        Review review = new Review();
        review.setUserFirstName("Matt");
        review.setStarValue(5);
        review.setId(1);
        reviewRepo.saveAndFlush(review);

        List<Review> allReviews = reviewRepo.findAll();
        assertEquals(1, allReviews.size());

        Review newReview = new Review();
        reviewRepo.saveAndFlush(newReview);
        allReviews = reviewRepo.findAll();
        assertEquals(2, allReviews.size());

        Review r = reviewRepo.findById(1).get();
        assertEquals("Matt", r.getUserFirstName());
    }

    @Test
    @Transactional
    void getReviewsByListingId(){

        Listing listing = new Listing();
        listingRepo.saveAndFlush(listing);

    }


}
