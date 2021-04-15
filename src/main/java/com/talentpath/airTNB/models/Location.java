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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="listing_id", nullable = false)
    private Listing listing;

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

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
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

        if (!id.equals(location.id)) return false;
        if (!listing.equals(location.listing)) return false;
        if (aboutLocations != null ? !aboutLocations.equals(location.aboutLocations) : location.aboutLocations != null)
            return false;
        return gettingAroundInfos != null ? gettingAroundInfos.equals(location.gettingAroundInfos) : location.gettingAroundInfos == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + listing.hashCode();
        result = 31 * result + (aboutLocations != null ? aboutLocations.hashCode() : 0);
        result = 31 * result + (gettingAroundInfos != null ? gettingAroundInfos.hashCode() : 0);
        return result;
    }
}
