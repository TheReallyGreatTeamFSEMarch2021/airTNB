package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HostRepository extends JpaRepository<Host,Integer> {
    @Transactional
    @Modifying
    @Query(value="alter table hosts auto_increment=1",
    nativeQuery = true)
    void reset();
}
