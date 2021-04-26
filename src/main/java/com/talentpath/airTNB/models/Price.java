package com.talentpath.airTNB.models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="prices")
public class Price {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Listing listing;

    private  float price;
    public Price(){
        
    }

    public Price(float price) {
        this.price = price;
    }
    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}
