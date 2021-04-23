package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.AboutLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutLocationRepository extends JpaRepository<AboutLocation, Integer> {
    List<AboutLocation> findByLocationId(Integer locationId);
}
