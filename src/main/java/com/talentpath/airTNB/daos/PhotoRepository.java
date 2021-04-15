package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findAllByListingId(Integer listingId);
}
