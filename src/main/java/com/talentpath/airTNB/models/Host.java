package com.talentpath.airTNB.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hosts")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean verified;
    private Boolean superHost;
    private String description;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Listing> listings;

    public Host(Boolean verified, Boolean superHost, String description, List<Listing> listings) {
        this.verified = verified;
        this.superHost = superHost;
        this.description = description;
        this.listings = listings;
    }

    public Host() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getSuperHost() {
        return superHost;
    }

    public void setSuperHost(Boolean superHost) {
        this.superHost = superHost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }
}
