package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.exceptions.NullReviewException;
import com.talentpath.airTNB.models.Review;
import com.talentpath.airTNB.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ReviewService service;

    @GetMapping("/getAll")
    public List<Review> getAllReviews() {
        return service.getAllReviews();
    }

    @GetMapping("/getByListing/{listingId}")
    public List<Review> getReviewsByHost(@PathVariable Integer listingId){
        return service.getByListing(listingId);
    }

    @GetMapping("/getById/{id}")
    public Review getReviewById(@PathVariable Integer id) throws NullReviewException {
        return service.getById(id);
    }
}
