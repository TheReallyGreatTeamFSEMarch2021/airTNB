package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="gettingAroundLocationInfos")
public class GettingAroundLocationInfo {
    public GettingAroundLocationInfo(){}

    public GettingAroundLocationInfo(@NotBlank Location location, @NotBlank String gettingAroundInfoStr){
        this.location = location;
        this.gettingAroundInfoStr = gettingAroundInfoStr;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @NotBlank
    private Location location;

    @NotBlank
    private String gettingAroundInfoStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getGettingAroundInfoStr() {
        return gettingAroundInfoStr;
    }

    public void setGettingAroundInfoStr(String gettingAroundInfoStr) {
        this.gettingAroundInfoStr = gettingAroundInfoStr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GettingAroundLocationInfo that = (GettingAroundLocationInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return gettingAroundInfoStr != null ? gettingAroundInfoStr.equals(that.gettingAroundInfoStr) : that.gettingAroundInfoStr == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (gettingAroundInfoStr != null ? gettingAroundInfoStr.hashCode() : 0);
        return result;
    }
}
