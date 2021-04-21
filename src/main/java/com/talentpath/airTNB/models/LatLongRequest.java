package com.talentpath.airTNB.models;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class LatLongRequest {


    private BigDecimal longitude;


    private BigDecimal latitude;

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
