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
        //private String title; // This is grabbed from Listing model
        private String hostEmail; // Can this be added to the Host model?
        private String hostImageURL; // Move this to Host Model?

        private String smallDescription;
        private String location; // Gets this from Location

        private String cancellationDate;
        private String typeOfPlace;
        // Count number of Reviews from other table
        // Get [Type of Place] + " in " + [City] + "hosted by "+ [host]
        // This is for testing purposes. Will be removed.
        public Description (){}

        public Description(String hostEmail, String smallDescription, String hostImageURL, String location, String cancellationDate, String typeOfPlace) {
                this.hostEmail = hostEmail;
                this.smallDescription = smallDescription;
                this.hostImageURL = hostImageURL;
                this.location = location;
                this.cancellationDate = cancellationDate;
                this.typeOfPlace = typeOfPlace;
        }

        public String getHostEmail() {
                return hostEmail;
        }

        public void setHostEmail(String hostEmail) {
                this.hostEmail = hostEmail;
        }

        public String getHostImageURL() {
                return hostImageURL;
        }

        public void setHostImageURL(String hostImageURL) {
                this.hostImageURL = hostImageURL;
        }

        public String getSmallDescription() {
                return smallDescription;
        }

        public void setSmallDescription(String smallDescription) {
                this.smallDescription = smallDescription;
        }

        public String getLocation() {
                return location;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public String getCancellationDate() {
                return cancellationDate;
        }

        public void setCancellationDate(String cancellationDate) {
                this.cancellationDate = cancellationDate;
        }

        public String getTypeOfPlace() {
                return typeOfPlace;
        }

        public void setTypeOfPlace(String typeOfPlace) {
                this.typeOfPlace = typeOfPlace;
        }

        @Override
        public String toString() {
                return "Description{" +
                        "id=" + id +
                        ", hostEmail='" + hostEmail + '\'' +
                        ", smallDescription='" + smallDescription + '\'' +
                        ", hostImageURL='" + hostImageURL + '\'' +
                        ", location='" + location + '\'' +
                        ", cancellationDate='" + cancellationDate + '\'' +
                        ", typeOfPlace='" + typeOfPlace + '\'' +
                        '}';
        }
}
