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

        Listing listingOne = new Listing();
        listingRepo.saveAndFlush(listingOne);

        Review review1 = new Review();
        review1.setStarValue(5);
        review1.setUserFirstName("Matt");
        review1.setListing(listingOne);
        reviewRepo.saveAndFlush(review1);

        Review review2 = new Review();
        review2.setStarValue(1);
        review2.setUserFirstName("Bob");
        review2.setListing(listingOne);
        reviewRepo.save(review2);

        List<Review> reviewsForListingOne = reviewRepo.findByListingId(listingOne.getId());

        assertEquals("Matt",reviewsForListingOne.get(0).getUserFirstName());
        assertEquals(5, reviewsForListingOne.get(0).getStarValue());

        assertEquals("Bob",reviewsForListingOne.get(1).getUserFirstName());
        assertEquals(1, reviewsForListingOne.get(1).getStarValue());

        Listing listingTwo = new Listing();
        listingRepo.saveAndFlush(listingTwo);

        Review review3 = new Review();
        review3.setStarValue(3);
        review3.setContent("abcdefg");
        review3.setListing(listingTwo);
        reviewRepo.saveAndFlush(review3);

        Review review4 = new Review();
        review4.setStarValue(2);
        review4.setContent("qwerty");
        review4.setListing(listingTwo);
        reviewRepo.saveAndFlush(review4);

        Review review5 = new Review();
        review5.setStarValue(4);
        review5.setContent("zzz");
        review5.setListing(listingTwo);
        reviewRepo.saveAndFlush(review5);

        List<Review> reviewsForListingTwo = reviewRepo.findByListingId(listingTwo.getId());

        assertEquals(3, reviewsForListingTwo.get(0).getStarValue());
        assertEquals("abcdefg", reviewsForListingTwo.get(0).getContent());

        assertEquals(2, reviewsForListingTwo.get(1).getStarValue());
        assertEquals("qwerty", reviewsForListingTwo.get(1).getContent());

        assertEquals(4, reviewsForListingTwo.get(2).getStarValue());
        assertEquals("zzz", reviewsForListingTwo.get(2).getContent());

    }

}
