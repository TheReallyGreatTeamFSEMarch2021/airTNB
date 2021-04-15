package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends JpaRepository<Amenity,Integer> {
    List<Amenity> findBylistingId(Integer id);
}
