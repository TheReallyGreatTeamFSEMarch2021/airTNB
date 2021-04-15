package com.talentpath.airTNB.models;


import javax.persistence.*;

@Entity
@Table(name="thingstoknow")
public class ThingToKnow {

    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="listing_id")
    @MapsId
    private Listing listing;

    @OneToOne(mappedBy="thingToKnow",
            cascade= CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    private RuleList ruleList;

    public ThingToKnow(Listing listing, RuleList ruleList) {
        this.listing = listing;
        this.ruleList = ruleList;
    }

    public ThingToKnow() {}

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public RuleList getRuleList() {
        return ruleList;
    }

    public void setRuleList(RuleList ruleList) {
        this.ruleList = ruleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
