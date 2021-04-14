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
        private String title;
        public Description(String title) {
                this.title = title;
        }
        // Get number of reviews
        // Location
        // Get [Type of Place] + " in " + [City] + "hosted by "+ [host]
        // Get Host image
        // Get Cancellation date if applicable
        // Get Brief description
        // Contact host email

}
