package com.talentpath.airTNB.services;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.talentpath.airTNB.daos.PriceRepository;
import com.talentpath.airTNB.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PriceService {
    @Autowired
    PriceRepository repo;

    public Map<String,Integer> testService(Integer id) {
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put("ID", id);
        return test;
    }
    public Optional<Price> getPrice(Integer id){
        return repo.findById(id);
    }
    public Price setPrice (Price newPrice){
        return repo.saveAndFlush(newPrice);
    }
}
