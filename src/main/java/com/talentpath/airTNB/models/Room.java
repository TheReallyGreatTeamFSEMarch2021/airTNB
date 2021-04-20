package com.talentpath.airTNB.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // type = bedroom/bathroom/common room/bathroom
    private String type;

    //name = "Bedroom 1", "Bedroom 2", "Common room 1", etc
    private String name;

    private Integer kBeds; //king beds
    private Integer qBeds; //queen beds
    private Integer dBeds; //double beds
    private Integer sBeds; //single beds
    private Integer cBeds; //couch beds

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,
            fetch=FetchType.LAZY)
    private Listing listing;

    public Room(int id, String type, String name, Integer kBeds, Integer qBeds, Integer dBeds, Integer sBeds, Integer cBeds, Listing listing) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.kBeds = kBeds;
        this.qBeds = qBeds;
        this.dBeds = dBeds;
        this.sBeds = sBeds;
        this.cBeds = cBeds;
        this.listing = listing;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getkBeds() {
        return kBeds;
    }

    public void setkBeds(Integer kBeds) {
        this.kBeds = kBeds;
    }

    public Integer getqBeds() {
        return qBeds;
    }

    public void setqBeds(Integer qBeds) {
        this.qBeds = qBeds;
    }

    public Integer getdBeds() {
        return dBeds;
    }

    public void setdBeds(Integer dBeds) {
        this.dBeds = dBeds;
    }

    public Integer getsBeds() {
        return sBeds;
    }

    public void setsBeds(Integer sBeds) {
        this.sBeds = sBeds;
    }

    public Integer getcBeds() {
        return cBeds;
    }

    public void setcBeds(Integer cBeds) {
        this.cBeds = cBeds;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && Objects.equals(type, room.type) && Objects.equals(name, room.name) && Objects.equals(kBeds, room.kBeds) && Objects.equals(qBeds, room.qBeds) && Objects.equals(dBeds, room.dBeds) && Objects.equals(sBeds, room.sBeds) && Objects.equals(cBeds, room.cBeds) && Objects.equals(listing, room.listing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, kBeds, qBeds, dBeds, sBeds, cBeds, listing);
    }
}
