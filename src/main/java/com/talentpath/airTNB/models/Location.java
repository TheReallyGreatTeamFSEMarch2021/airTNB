package com.talentpath.airTNB.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="locations")
public class Location {
    public Location(){

    }


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<Listing> listings;

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<AboutLocation> locationInfos;

    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<GettingAroundLocationInfo> gettingAroundLocationInfos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        if (listings != null ? !listings.equals(location.listings) : location.listings != null) return false;
        if (locationInfos != null ? !locationInfos.equals(location.locationInfos) : location.locationInfos != null)
            return false;
        return gettingAroundLocationInfos != null ? gettingAroundLocationInfos.equals(location.gettingAroundLocationInfos) : location.gettingAroundLocationInfos == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listings != null ? listings.hashCode() : 0);
        result = 31 * result + (locationInfos != null ? locationInfos.hashCode() : 0);
        result = 31 * result + (gettingAroundLocationInfos != null ? gettingAroundLocationInfos.hashCode() : 0);
        return result;
    }
}
