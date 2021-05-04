package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javassist.runtime.Desc;
import org.hibernate.annotations.Cascade;

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

    private Integer freeCancellationDays;

    private Integer cancellationRefundPercentage;

    private Integer paidCancellationDays;
    
    private float price;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,
                cascade=CascadeType.ALL)
    @JoinColumn(name="host_id")
    private Host host;

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    private List<Photo>  photos;

    @OneToOne(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "listing")
    @NotBlank
    private Location location;

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    private List<Room>  rooms;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Description description;

    @OneToOne(mappedBy = "listing",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private RuleList ruleList;

    @OneToOne(mappedBy = "listing",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private HealthAndSafetyInfo healthAndSafetyInfo;
    
    public Listing(String title, String subTitle, Host host, List<Review> reviews, List<Photo> photos, Description description, float price){
        this.title = title;
        this.subTitle = subTitle;
        this.host = host;
        this.reviews = reviews;
        this.photos = photos;
        this.description = description;
        this.price = price;
    }

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

    public Description getDescription(){
        return description;
    }
    public void setDescription(Description description){
        this.description = description;
    }
    public float getPrice(){
        return price;
    }
    public void setPrice(Float price){
        this.price = price;
    }

    public HealthAndSafetyInfo getHealthAndSafetyInfo() {
        return healthAndSafetyInfo;
    }

    public void setHealthAndSafetyInfo(HealthAndSafetyInfo healthAndSafetyInfo) {
        this.healthAndSafetyInfo = healthAndSafetyInfo;
    }
}
