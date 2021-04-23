package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {
    @Query("SELECT l FROM Listing l WHERE l.location.latitude > :lat1 AND l.location.latitude < :lat2 AND l.location.longitude > :long1 AND l.location.longitude < :long2")
    List<Listing> findCloseLocationsByLatAndLong(BigDecimal lat1, BigDecimal lat2, BigDecimal long1, BigDecimal long2);


    @Query("SELECT l FROM Listing l WHERE LOWER(l.location.city) = LOWER(:city) AND LOWER(l.location.state) = LOWER(:state)")
    List<Listing> findAllByLocationCityState(String city, String state);
}
