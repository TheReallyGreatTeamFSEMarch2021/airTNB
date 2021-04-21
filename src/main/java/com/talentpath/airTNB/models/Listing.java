package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javassist.runtime.Desc;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String subTitle;

    private String state;

    private String city;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private Host host;

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @JsonIgnore
    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    private List<Photo>  photos;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Room>  rooms;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Description description;

    public Listing(String title, String subTitle, String state, String city, Host host, List<Review> reviews, List<Photo> photos, Description description){
        this.title = title;
        this.subTitle = subTitle;
        this.state = state;
        this.city = city;
        this.host = host;
        this.reviews = reviews;
        this.photos = photos;
        this.description = description;
    }

    public Listing(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public Description getDescription(){
        return description;
    }
    public void setDescription(Description description){
        this.description = description;
    }
}
