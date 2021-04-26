package com.talentpath.airTNB.controllers;

import com.talentpath.airTNB.models.Price;
import com.talentpath.airTNB.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/price")
public class PriceController {

        @Autowired
        PriceService priceService;

        @GetMapping("/{id}")
        public Optional<Price> getPrice (@PathVariable Integer id){
                return priceService.getPrice(id);
        }

        @PostMapping("/add")
        public Price postPrice (@RequestBody Price newPrice){
                return priceService.setPrice(newPrice);
        }
}
