package com.talentpath.airTNB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;
@Entity
@Table(name="description")
public class Description {
        @Id
        @GeneratedValue
        private Integer id;
        private String title; // Can this be grabbed from an existing table?
        private String hostEmail;
        private String smallDescription;
        private String hostImageURL;
        private String location;
        private String cancellationDate;
        private String typeOfPlace;
        // Count number of Reviews from other table
        // Get [Type of Place] + " in " + [City] + "hosted by "+ [host]
        
}
