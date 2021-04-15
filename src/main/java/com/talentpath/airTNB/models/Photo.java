package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.talentpath.airTNB.exceptions.NullListingException;
import com.talentpath.airTNB.services.ListingService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String url;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,
                fetch=FetchType.LAZY)

    private Listing listing;

    public Photo(){
    }

    public Photo(int id, String url, Listing listing) {
        this.id = id;
        this.url = url;
        this.listing = listing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

}
