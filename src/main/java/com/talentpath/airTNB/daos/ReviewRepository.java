package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    //List<Review> findReviewsForHostId(Integer hostId);

    @Modifying
    @Query(
            value = "truncate reviews restart identity cascade",
            nativeQuery = true
    )
    void reset();

}
