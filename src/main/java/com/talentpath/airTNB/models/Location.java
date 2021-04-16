package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="locations")
public class Location {
    //Listing item
    //AboutLocation
    //GettingAround

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToMany(mappedBy="location", cascade=CascadeType.ALL)
    private List<Listing> listings;

    @OneToMany(mappedBy="location", cascade = CascadeType.ALL)
    private List<AboutLocation> aboutLocations;

    @OneToMany(mappedBy="location", cascade = CascadeType.ALL)
    private List<GettingAroundInfo> gettingAroundInfos;

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

    public List<AboutLocation> getAboutLocations() {
        return aboutLocations;
    }

    public void setAboutLocations(List<AboutLocation> aboutLocations) {
        this.aboutLocations = aboutLocations;
    }

    public List<GettingAroundInfo> getGettingAroundInfos() {
        return gettingAroundInfos;
    }

    public void setGettingAroundInfos(List<GettingAroundInfo> gettingAroundInfos) {
        this.gettingAroundInfos = gettingAroundInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        if (listings != null ? !listings.equals(location.listings) : location.listings != null) return false;
        if (aboutLocations != null ? !aboutLocations.equals(location.aboutLocations) : location.aboutLocations != null)
            return false;
        return gettingAroundInfos != null ? gettingAroundInfos.equals(location.gettingAroundInfos) : location.gettingAroundInfos == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (listings != null ? listings.hashCode() : 0);
        result = 31 * result + (aboutLocations != null ? aboutLocations.hashCode() : 0);
        result = 31 * result + (gettingAroundInfos != null ? gettingAroundInfos.hashCode() : 0);
        return result;
    }
}
