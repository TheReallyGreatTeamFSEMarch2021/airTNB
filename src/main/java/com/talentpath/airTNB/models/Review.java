package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @NotBlank
    private Host host;

    private String title;

    private String content;

    private Integer starValue;

    public Review(){

    }

    public Review(String title, String content, Integer starValue){
        this.title = title;
        this.content = content;
        this.starValue = starValue;
    }

    public Review(Review review){
        this.id = review.id;
        this.host = review.host;
        this.title = review.title;
        this.content = review.content;
        this.starValue = review.starValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Host getHost(){
        return host;
    }

    public void setHost(Host host){
        this.host = host;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != null ? !id.equals(review.id) : review.id != null) return false;
        if (host != null ? !host.equals(review.host) : review.host != null) return false;
        if (title != null ? !title.equals(review.title) : review.title != null) return false;
        if (content != null ? !content.equals(review.content) : review.content != null) return false;
        return starValue != null ? starValue.equals(review.starValue) : review.starValue == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (starValue != null ? starValue.hashCode() : 0);
        return result;
    }
}
