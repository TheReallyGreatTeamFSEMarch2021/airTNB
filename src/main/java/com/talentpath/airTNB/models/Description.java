package com.talentpath.airTNB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Description {
        @Id
        @GeneratedValue
        private Long id;
        private String title;
        // Get number of reviews
        // Location
        // Get [Type of Place] + " in " + [City] + "hosted by "+ [host]
        // Get Host image
        // Get Cancellation date if applicable
        // Get Brief description
        // Contact host email

}
