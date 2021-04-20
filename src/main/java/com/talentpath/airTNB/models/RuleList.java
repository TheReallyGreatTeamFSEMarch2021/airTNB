package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="rulelists")
public class RuleList {
    @Id
    private Integer id;

    private String checkInTime;
    private String checkOutTime;
    private Boolean smokingAllowed;
    private Boolean petsAllowed;
    private Boolean childSuitable;
    private Boolean partiesAllowed;
    private String otherRules;

    @Enumerated(EnumType.STRING)
    private CheckInMethod checkInMethod;



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="listing_id")
    @MapsId
    @JsonIgnore
    private Listing listing;

    public RuleList(String checkInTime, String checkOutTime, Boolean smokingAllowed, Boolean petsAllowed, Boolean childSuitable, Boolean partiesAllowed, CheckInMethod checkInMethod, Listing listing) {
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.smokingAllowed = smokingAllowed;
        this.petsAllowed = petsAllowed;
        this.childSuitable = childSuitable;
        this.partiesAllowed = partiesAllowed;
        this.checkInMethod = checkInMethod;
        this.listing = listing;
    }

    public RuleList(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Boolean getSmokingAllowed() {
        return smokingAllowed;
    }

    public void setSmokingAllowed(Boolean smokingAllowed) {
        this.smokingAllowed = smokingAllowed;
    }

    public Boolean getPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(Boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public Boolean getChildSuitable() {
        return childSuitable;
    }

    public void setChildSuitable(Boolean childSuitable) {
        this.childSuitable = childSuitable;
    }

    public Boolean getPartiesAllowed() {
        return partiesAllowed;
    }

    public void setPartiesAllowed(Boolean partiesAllowed) {
        this.partiesAllowed = partiesAllowed;
    }

    public CheckInMethod getCheckInMethod() {
        return checkInMethod;
    }

    public void setCheckInMethod(CheckInMethod checkInMethod) {
        this.checkInMethod = checkInMethod;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public String getOtherRules() {
        return otherRules;
    }

    public void setOtherRules(String otherRules) {
        this.otherRules = otherRules;
    }
}
