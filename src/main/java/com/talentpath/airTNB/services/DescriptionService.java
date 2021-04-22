package com.talentpath.airTNB.services;

import java.util.Optional;

import com.talentpath.airTNB.daos.DescriptionRepository;
import com.talentpath.airTNB.models.Description;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescriptionService {
    @Autowired
    DescriptionRepository repo;

    public Optional<Description> getDescription(Integer id) {
        return repo.findById(id);
    }
    public Description addDescription(Description newDesc) {
        return repo.saveAndFlush(newDesc);
    }
}
