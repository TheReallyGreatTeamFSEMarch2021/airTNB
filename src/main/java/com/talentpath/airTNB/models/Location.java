package com.talentpath.airTNB.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="locations")
public class Location {
<<<<<<< HEAD

=======
>>>>>>> staging
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Digits(integer=3, fraction=6)
    private BigDecimal longitude;

    @Digits(integer=3, fraction=6)
    private BigDecimal latitude;

    @OneToOne
    private Listing listing;
//    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
//    private List<Listing> listings;

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<AboutLocation> locationInfos;

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<GettingAroundLocationInfo> gettingAroundLocationInfos;

    public Location(){
    }

    public Location(BigDecimal latitude, BigDecimal longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public List<AboutLocation> getLocationInfos() {
        return locationInfos;
    }

    public void setLocationInfos(List<AboutLocation> locationInfos) {
        this.locationInfos = locationInfos;
    }

    public List<GettingAroundLocationInfo> getGettingAroundLocationInfos() {
        return gettingAroundLocationInfos;
    }

    public void setGettingAroundLocationInfos(List<GettingAroundLocationInfo> gettingAroundLocationInfos) {
        this.gettingAroundLocationInfos = gettingAroundLocationInfos;
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

        Location location = (Location) o;

        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        if (longitude != null ? !longitude.equals(location.longitude) : location.longitude != null) return false;
        if (latitude != null ? !latitude.equals(location.latitude) : location.latitude != null) return false;
        if (listing != null ? !listing.equals(location.listing) : location.listing != null) return false;
        if (locationInfos != null ? !locationInfos.equals(location.locationInfos) : location.locationInfos != null)
            return false;
        return gettingAroundLocationInfos != null ? gettingAroundLocationInfos.equals(location.gettingAroundLocationInfos) : location.gettingAroundLocationInfos == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (listing != null ? listing.hashCode() : 0);
        result = 31 * result + (locationInfos != null ? locationInfos.hashCode() : 0);
        result = 31 * result + (gettingAroundLocationInfos != null ? gettingAroundLocationInfos.hashCode() : 0);
        return result;
    }
}
