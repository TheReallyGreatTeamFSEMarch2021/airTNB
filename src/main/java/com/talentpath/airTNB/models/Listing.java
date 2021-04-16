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

    @Digits(integer=3, fraction=6)
    private BigDecimal longitude;

    @Digits(integer=3, fraction=6)
    private BigDecimal latitude;

    private String state;

    private String city;

    @OneToOne(mappedBy = "listing", cascade = CascadeType.ALL)
    private Host host;

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @NotBlank
    private Location location;



}
