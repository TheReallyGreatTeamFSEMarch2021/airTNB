package com.talentpath.airTNB.models;


import javax.persistence.*;

@Entity
@Table(name="thingstoknow")
public class ThingToKnow {
    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Listing listing;

    @OneToOne(mappedBy="thingToKnow",
            cascade= CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    private RuleList ruleList;


}
