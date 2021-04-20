package com.talentpath.airTNB.models;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="price")
public class Price {
    @Id
    @GeneratedValue
    @Column(name = "priceId")
    private Integer id;
    /*
    // Not sure if this is the right way.
    @OneToOne(mappedBy = "id")
    private Listing listing;
    //*/
    private  float price;

    public Price(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Price{" +
                "price=" + price +
                '}';
    }
}
