package com.talentpath.airTNB.models;

import javax.persistence.*;

@Entity
@Table(name="rulelists")
public class RuleList {
    @Id
    private Integer id;

    @OneToOne(fetch= FetchType.LAZY)
    @MapsId
    private ThingToKnow thingToKnow;
}
