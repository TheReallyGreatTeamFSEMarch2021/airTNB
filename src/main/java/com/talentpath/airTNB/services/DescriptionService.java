package com.talentpath.airTNB.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.talentpath.airTNB.daos.DescriptionRepository;
import com.talentpath.airTNB.models.Description;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescriptionService {
    @Autowired
    DescriptionRepository repo;

    public Map<String,Integer> testService(Integer id) {
        Map<String, Integer> test = new HashMap<String,Integer>();
        test.put("ID", id);
        return test;
    }
    public Optional<Description> getDescription(Integer id) {
        return repo.findById(id);
    }
    public Description addDescription(Description newDesc, Integer id) {
        // Figure out how to map this to the listing model
        return repo.saveAndFlush(newDesc);
    }
}
