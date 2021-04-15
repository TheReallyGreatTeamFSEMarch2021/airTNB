package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.AboutLocation;
import com.talentpath.airTNB.models.GettingAroundInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface GettingAroundInfoRepository extends JpaRepository<GettingAroundInfo, Integer> {
    List<GettingAroundInfo> findByLocationId(Integer locationId);

    @Modifying
    @Query(
            value="truncate aboutLocations restart identity cascade",
            nativeQuery = true
    )
    void reset();
}
