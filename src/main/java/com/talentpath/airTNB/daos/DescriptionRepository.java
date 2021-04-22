package com.talentpath.airTNB.daos;

import com.talentpath.airTNB.models.Description;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Integer>{}
