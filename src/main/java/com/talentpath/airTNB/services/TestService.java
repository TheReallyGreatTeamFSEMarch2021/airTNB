package com.talentpath.airTNB.services;

import com.talentpath.airTNB.daos.TestRepository;
import com.talentpath.airTNB.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepository testRepo;

    public List<Test> getAllTests() {
        return testRepo.findAll();
    }

    public Test addTest(Test toAdd) {
        return testRepo.saveAndFlush(toAdd);
    }
}
