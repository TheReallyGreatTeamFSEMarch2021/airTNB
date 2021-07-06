package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "events")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Event {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="listing_id")
    @NotBlank
    private Listing listing;

    private String name;

    private String details;

    private String start;

    private String end;

    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.talentpath.airTNB.models.Listing getListing() {
        return listing;
    }

    public void setListing(com.talentpath.airTNB.models.Listing listing) {
        this.listing = listing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
