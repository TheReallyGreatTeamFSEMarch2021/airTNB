package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @NotBlank
    private Listing listing;

    private String title;

    private String content;

    private Integer starValue;

    private LocalDate date;

    private String userFirstName;

    public Review(){

    }

    public Review(@NotBlank Listing listing, String title, String content, Integer starValue, LocalDate date, String userFirstName) {
        this.listing = listing;
        this.title = title;
        this.content = content;
        this.starValue = starValue;
        this.date = date;
        this.userFirstName = userFirstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Listing getListing(){
        return listing;
    }

    public void setListing(Listing listing){
        this.listing = listing;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStarValue() {
        return starValue;
    }

    public void setStarValue(Integer starValue) {
        this.starValue = starValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != null ? !id.equals(review.id) : review.id != null) return false;
        if (listing != null ? !listing.equals(review.listing) : review.listing != null) return false;
        if (title != null ? !title.equals(review.title) : review.title != null) return false;
        if (content != null ? !content.equals(review.content) : review.content != null) return false;
        if (starValue != null ? !starValue.equals(review.starValue) : review.starValue != null) return false;
        if (date != null ? !date.equals(review.date) : review.date != null) return false;
        return userFirstName != null ? userFirstName.equals(review.userFirstName) : review.userFirstName == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listing != null ? listing.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (starValue != null ? starValue.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userFirstName != null ? userFirstName.hashCode() : 0);
        return result;
    }
}
