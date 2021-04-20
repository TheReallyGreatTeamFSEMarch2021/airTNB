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
        // Call service
        @Autowired
        PriceService priceService;
    
        // This will be removed at some point.
        @GetMapping("/test/{id}")
        public String getTest(@PathVariable Integer id){
            return "Current ID: " + id;
        }

        @GetMapping("/price/{id}")
        public Optional<Price> getPrice (@PathVariable Integer id){
                return priceService.getPrice(id);
        }

        @PostMapping("/price")
        public Price postPrice (@RequestBody Price newPrice){
                System.out.println(newPrice.toString());
                return PriceService.setPrice(newPrice);
        }
}
