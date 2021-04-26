package com.talentpath.airTNB.services;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.talentpath.airTNB.controllers.PriceController;
import com.talentpath.airTNB.models.Price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PriceServiceTest {
    @Autowired
    private PriceController controller;


    @Test
    public void addPriceShouldReturnPrice (){
        Price newPrice = new Price((float) 1.23);
        Price returnedPrice = controller.postPrice(newPrice);
        assertSame(newPrice, returnedPrice);
    }
    @Test
    public void getPriceShouldReturnPrice(){
        
    }
}
