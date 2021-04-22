package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private Host host;

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Photo>  photos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @NotBlank
    private Location location;


    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Room>  rooms;

    public Listing(String title, String subTitle, Host host, List<Review> reviews, List<Photo> photos){
        this.title = title;
        this.subTitle = subTitle;
        this.host = host;
        this.reviews = reviews;
        this.photos = photos;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
