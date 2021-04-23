package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.GettingAroundLocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GettingAroundLocationInfoRepository extends JpaRepository<GettingAroundLocationInfo, Integer> {
    List<GettingAroundLocationInfo> findByLocationId(Integer locationId);

}


