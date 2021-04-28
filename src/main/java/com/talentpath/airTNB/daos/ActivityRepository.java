package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    List<Activity> findByCity(String city);

    @Modifying
    @Query(
            value = "alter table activities auto_increment=1",
            nativeQuery = true
    )
    void reset();
}
