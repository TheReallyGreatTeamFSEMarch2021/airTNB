package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.ReviewRepository;
import com.talentpath.airTNB.exceptions.NullReviewException;
import com.talentpath.airTNB.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepo;

    public List<Review> getAllReviews(){return reviewRepo.findAll();}

//    public List<Review> getByHost(Integer hostId){
//        return reviewRepo.findReviewsForHost(Integer hostId);
//    }

    public Review getById(Integer id) throws NullReviewException {
        Optional<Review> review = reviewRepo.findById(id);
        if(review.isPresent()) {
            return review.get();
        }else{
            throw new NullReviewException("No Review with id: " +  id);
        }
    }

    @Transactional
    public void resetReviews(){
        reviewRepo.reset();
    }
}
