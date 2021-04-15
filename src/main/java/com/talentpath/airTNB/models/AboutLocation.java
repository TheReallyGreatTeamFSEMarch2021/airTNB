package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="aboutLocations")
public class AboutLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String aboutLocation;

    @Min(value = 1, message = "order of aboutLocation should be greater than or equal to 1")
    private Integer order;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @NotBlank
    private Location location;

    public AboutLocation(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAboutLocation() {
        return aboutLocation;
    }

    public void setAboutLocation(String aboutLocation) {
        this.aboutLocation = aboutLocation;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AboutLocation that = (AboutLocation) o;

        if (!id.equals(that.id)) return false;
        if (!aboutLocation.equals(that.aboutLocation)) return false;
        if (!order.equals(that.order)) return false;
        return location.equals(that.location);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + aboutLocation.hashCode();
        result = 31 * result + order.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
}
