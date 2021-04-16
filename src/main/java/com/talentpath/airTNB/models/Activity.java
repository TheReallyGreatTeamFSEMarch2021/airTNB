package com.talentpath.airTNB.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Entity
@Table(name="activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String thumbNail;

    @NotBlank
    private Integer price;

    @NotBlank
    private String title;

    private String country;

    private String region;

    private String city;

    @Digits(integer=3, fraction=6)
    private BigDecimal longitude;

    @Digits(integer=3, fraction=6)
    private BigDecimal latitude;

    public Activity(){

    }

    public Activity(Integer id, @NotBlank String thumbNail, @NotBlank Integer price, @NotBlank String title, String country, String region, String city, @Digits(integer = 3, fraction = 6) BigDecimal longitude, @Digits(integer = 3, fraction = 6) BigDecimal latitude) {
        this.id = id;
        this.thumbNail = thumbNail;
        this.price = price;
        this.title = title;
        this.country = country;
        this.region = region;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (id != null ? !id.equals(activity.id) : activity.id != null) return false;
        if (thumbNail != null ? !thumbNail.equals(activity.thumbNail) : activity.thumbNail != null) return false;
        if (price != null ? !price.equals(activity.price) : activity.price != null) return false;
        if (title != null ? !title.equals(activity.title) : activity.title != null) return false;
        if (country != null ? !country.equals(activity.country) : activity.country != null) return false;
        if (region != null ? !region.equals(activity.region) : activity.region != null) return false;
        if (city != null ? !city.equals(activity.city) : activity.city != null) return false;
        if (longitude != null ? !longitude.equals(activity.longitude) : activity.longitude != null) return false;
        return latitude != null ? latitude.equals(activity.latitude) : activity.latitude == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (thumbNail != null ? thumbNail.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        return result;
    }
}
