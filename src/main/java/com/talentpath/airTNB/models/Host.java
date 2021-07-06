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
    private String name;
    private Integer responseRate;
    private String responseTime;
    private String duringYourStay;
    private String languages;


    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Listing> listings;
    
    private String hostEmail;
    private String hostImageURL;

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

    public Boolean isVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean isSuperHost() {
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
    public Host(String hostEmail, String hostImageURL){
        this.hostEmail = hostEmail;
        this.hostImageURL = hostImageURL;
    }
    public String getHostEmail() {
        return hostEmail;
    }
    public void setHostEmail(String hostEmail) {
            this.hostEmail = hostEmail;
    }
    public String getHostImageURL() {
        return hostImageURL;
    }
    public void setHostImageURL(String hostImageURL) {
        this.hostImageURL = hostImageURL;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Boolean getSuperHost() {
        return superHost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(Integer responseRate) {
        this.responseRate = responseRate;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getDuringYourStay() {
        return duringYourStay;
    }

    public void setDuringYourStay(String duringYourStay) {
        this.duringYourStay = duringYourStay;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
