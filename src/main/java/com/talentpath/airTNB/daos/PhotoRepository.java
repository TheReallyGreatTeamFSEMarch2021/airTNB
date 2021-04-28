package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findAllByListingId(Integer listingId);

    @Transactional
    @Modifying
    @Query(value="alter table photo auto_increment=1",
            nativeQuery = true)
    void reset();
}
