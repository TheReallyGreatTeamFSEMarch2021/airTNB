package com.talentpath.airTNB.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hosts")
public class Host {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Review> reviews;
}
