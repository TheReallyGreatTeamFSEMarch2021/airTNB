package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findAllByListingId(Integer listingId);

    @Transactional
    @Modifying
    @Query(value="alter table room auto_increment=1",
            nativeQuery = true)
    void reset();
}
