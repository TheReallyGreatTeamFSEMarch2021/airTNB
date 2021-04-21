package com.talentpath.airTNB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
@Table(name="descriptions")
public class Description {
        @Id
        @GeneratedValue
        private Integer id;
        
        @OneToOne(cascade = CascadeType.ALL)
        @JsonIgnore
        private Listing listing;
        
        // These need to be moved into the host model
        private String hostEmail;
        private String hostImageURL;

        private String smallDescription;
        private String cancellationDate;

        // Is this in the listing?
        private String typeOfPlace;

        public Description (){}

        public Description(String hostEmail, String smallDescription, String hostImageURL, String cancellationDate, String typeOfPlace) {
                this.hostImageURL = hostImageURL;
                this.smallDescription = smallDescription;
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
                        ", cancellationDate='" + cancellationDate + '\'' +
                        ", typeOfPlace='" + typeOfPlace + '\'' +
                        '}';
        }
}
