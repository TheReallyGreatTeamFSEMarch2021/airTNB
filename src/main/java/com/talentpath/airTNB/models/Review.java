package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="reviews")
public class Review {

    // Todo:
    // Add Equals & Hash Code once Host Model has been set up

    @Id
    @GeneratedValue
    private Integer id;

    //    @JsonIgnore
    //    @ManyToOne(fetch= FetchType.LAZY)
    //    @NotBlank
    //    private Host host;

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
        //this.host = review.host;
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

//    public Host getHost(){
//        return host;
//    }
//
//    public void setHost(Host host){
//        this.host = host;
//    }

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
}
