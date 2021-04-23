package com.talentpath.airTNB.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="hosts")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "host", cascade = CascadeType.ALL)
    private List<Listing> listings;
    
    private String hostEmail;
    private String hostImageURL;

    public Host(){}
    public Host(String hostEmail, String hostImageURL){
        this.hostEmail = hostEmail;
        this.hostImageURL = hostImageURL;
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
}
