package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByListingId(Integer listingId);

    @Modifying
    @Query(
            value="truncate locations restart identity cascade",
            nativeQuery = true
    )
    void reset();

}
