package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name="healthandsafetyinfos")
public class HealthAndSafetyInfo {
    @Id
    private Integer id;

    private Boolean enhancedCleaning;
    private Boolean cMonAlarm;
    private Boolean smokeAlarm;
    private Integer securityDeposit;
    private String petsInfo;
    private String sharedSpaces;
    private String stairs;
    private String parkingInfo;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="listing_id")
    @MapsId
    @JsonIgnore
    private Listing listing;

    public HealthAndSafetyInfo(Boolean enhancedCleaning, Boolean cMonAlarm, Boolean smokeAlarm, Integer securityDeposit, String petsInfo, String sharedSpaces, String stairs, String parkingInfo) {
        this.enhancedCleaning = enhancedCleaning;
        this.cMonAlarm = cMonAlarm;
        this.smokeAlarm = smokeAlarm;
        this.securityDeposit = securityDeposit;
        this.petsInfo = petsInfo;
        this.sharedSpaces = sharedSpaces;
        this.stairs = stairs;
        this.parkingInfo = parkingInfo;
    }

    public HealthAndSafetyInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getEnhancedCleaning() {
        return enhancedCleaning;
    }

    public void setEnhancedCleaning(Boolean enhancedCleaning) {
        this.enhancedCleaning = enhancedCleaning;
    }

    public Boolean getcMonAlarm() {
        return cMonAlarm;
    }

    public void setcMonAlarm(Boolean cMonAlarm) {
        this.cMonAlarm = cMonAlarm;
    }

    public Boolean getSmokeAlarm() {
        return smokeAlarm;
    }

    public void setSmokeAlarm(Boolean smokeAlarm) {
        this.smokeAlarm = smokeAlarm;
    }

    public Integer getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(Integer securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public String getPetsInfo() {
        return petsInfo;
    }

    public void setPetsInfo(String petsInfo) {
        this.petsInfo = petsInfo;
    }

    public String getSharedSpaces() {
        return sharedSpaces;
    }

    public void setSharedSpaces(String sharedSpaces) {
        this.sharedSpaces = sharedSpaces;
    }

    public String getStairs() {
        return stairs;
    }

    public void setStairs(String stairs) {
        this.stairs = stairs;
    }

    public String getParkingInfo() {
        return parkingInfo;
    }

    public void setParkingInfo(String parkingInfo) {
        this.parkingInfo = parkingInfo;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }
}
