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
        
        private String smallDescription;
        private String cancellationDate;

        // Is this in the listing?
        private String typeOfPlace;

        public Description (){}

        public Description(String smallDescription, String cancellationDate, String typeOfPlace) {
                
                this.smallDescription = smallDescription;
                this.cancellationDate = cancellationDate;
                this.typeOfPlace = typeOfPlace;
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
                        ", smallDescription='" + smallDescription + '\'' +
                        ", cancellationDate='" + cancellationDate + '\'' +
                        ", typeOfPlace='" + typeOfPlace + '\'' +
                        '}';
        }
}
