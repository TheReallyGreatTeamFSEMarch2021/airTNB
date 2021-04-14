package com.talentpath.airTNB.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hosts")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="listing_id", nullable = false)
    private Listing listing;


}
