package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.AboutLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AboutLocationRepository extends JpaRepository<AboutLocation, Integer> {
    List<AboutLocation> findByLocationId(Integer locationId);

    @Modifying
    @Query(
            value="truncate aboutLocations restart identity cascade",
            nativeQuery = true
    )
    void reset();
}
