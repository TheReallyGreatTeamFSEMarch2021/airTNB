package com.talentpath.airTNB.models;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class LatLongRequest {
    @NotBlank
    @Digits(integer=3, fraction=6)
    private BigDecimal longitude;

    @NotBlank
    @Digits(integer=3, fraction=6)
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
