package com.ura.casemgt.infrastructure.database.hibernate.dto;

import com.ura.casemgt.domain.shared.LocationType;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author smallGod
 */
@Embeddable
public class PlaceOfOffenceEmbeddable {

    @Column(name = "location_type")
    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    @Column(name = "location_name")
    private String locationName;

    public PlaceOfOffenceEmbeddable() {}

    public PlaceOfOffenceEmbeddable(LocationType locationType,
                                    String locationName) {
        this.locationType = locationType;
        this.locationName = locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
