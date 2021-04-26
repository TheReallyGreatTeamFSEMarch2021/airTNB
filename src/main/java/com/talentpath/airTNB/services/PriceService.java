package com.talentpath.airTNB.services;

import java.util.Optional;

import com.talentpath.airTNB.daos.PriceRepository;
import com.talentpath.airTNB.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    @Autowired
    PriceRepository repo;

    public Optional<Price> getPrice(Integer id){
        return repo.findById(id);
    }
    public Price setPrice (Price newPrice){
        return repo.saveAndFlush(newPrice);
    }
}
