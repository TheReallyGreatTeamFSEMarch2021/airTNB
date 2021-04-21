package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {
    List<Listing> findByCityIgnoreCaseAndStateIgnoreCase(String city, String state);

}
