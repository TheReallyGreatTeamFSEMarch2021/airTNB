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
        // This is for testing purposes. Will be removed.
        public Description(String title, String hostEmail, String smallDescription, String hostImageURL, String location, String cancellationDate, String typeOfPlace) {
                this.title = title;
                this.hostEmail = hostEmail;
                this.smallDescription = smallDescription;
                this.hostImageURL = hostImageURL;
                this.location = location;
                this.cancellationDate = cancellationDate;
                this.typeOfPlace = typeOfPlace;
        }

        @Override
        public String toString() {
                return "Description{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", hostEmail='" + hostEmail + '\'' +
                        ", smallDescription='" + smallDescription + '\'' +
                        ", hostImageURL='" + hostImageURL + '\'' +
                        ", location='" + location + '\'' +
                        ", cancellationDate='" + cancellationDate + '\'' +
                        ", typeOfPlace='" + typeOfPlace + '\'' +
                        '}';
        }
}
