package com.talentpath.airTNB.services;

import java.util.HashMap;
import java.util.Map;

import com.talentpath.airTNB.daos.DescriptionRepository;
import com.talentpath.airTNB.models.Description;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescriptionService {
    //@Autowired
    //DescriptionRepository repo;

    public Map<String,Integer> testService(Integer id) {
        Map<String, Integer> test = new HashMap<String,Integer>();
        test.put("ID", id);
        return test;
    }
    public Description getDescription(Integer id){
        // Use the ID to get the relevant data
        return new Description();
    }
}
