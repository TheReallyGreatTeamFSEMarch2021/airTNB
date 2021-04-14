package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {
}
