package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByListingId(Integer listingId);

    @Modifying
    @Query(
            value = "alter table reviews auto_increment=1",
            nativeQuery = true
    )
    void reset();

}
