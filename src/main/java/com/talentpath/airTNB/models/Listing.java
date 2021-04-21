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

    private String state;

    private String city;

    private Integer freeCancellationDays;

    private Integer cancellationRefundPercentage;

    private Integer paidCancellationDays;

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

    @OneToOne(mappedBy = "listing",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private RuleList ruleList;

    public Listing(String title, String subTitle, String state, String city, Host host, List<Review> reviews, List<Photo> photos){
        this.title = title;
        this.subTitle = subTitle;
        this.state = state;
        this.city = city;
        this.host = host;
        this.reviews = reviews;
        this.photos = photos;
    }

    public Listing(){
    }

    public Integer getId() {
        return id;
    }

    public Integer getFreeCancellationDays() {
        return freeCancellationDays;
    }

    public void setFreeCancellationDays(Integer freeCancellationDays) {
        this.freeCancellationDays = freeCancellationDays;
    }

    public Integer getCancellationRefundPercentage() {
        return cancellationRefundPercentage;
    }

    public void setCancellationRefundPercentage(Integer cancellationRefundPercentage) {
        this.cancellationRefundPercentage = cancellationRefundPercentage;
    }

    public Integer getPaidCancellationDays() {
        return paidCancellationDays;
    }

    public void setPaidCancellationDays(Integer paidCancellationDays) {
        this.paidCancellationDays = paidCancellationDays;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public RuleList getRuleList() {
        return ruleList;
    }

    public void setRuleList(RuleList ruleList) {
        this.ruleList = ruleList;
    }
}
