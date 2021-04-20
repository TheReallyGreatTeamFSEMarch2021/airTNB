package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository <Price, Integer> {
}
