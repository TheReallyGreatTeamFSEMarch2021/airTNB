package com.talentpath.airTNB.models;

import javax.persistence.*;

@Entity
@Table(name="rulelists")
public class RuleList {
    @Id
    private Integer id;

    private String checkInTime;
    private String checkOutTime;
    private Boolean smokingAllowed;
    private Boolean petsAllowed;
    private Boolean childSuitable;
    private Boolean partiesAllowed;
    private CheckInMethod checkInMethod;



    @OneToOne(fetch= FetchType.LAZY)
    @MapsId
    private ThingToKnow thingToKnow;
}
