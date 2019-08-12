package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.LocationName;
import com.ura.casemgt.domain.shared.LocationType;
import com.ura.casemgt.domain.shared.ValueObject;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author smallGod
 **/
public final class PlaceOfOffence implements ValueObject<PlaceOfOffence> {

    private final LocationType locationType;
    private final LocationName locationName;

    public PlaceOfOffence(LocationType locationType, LocationName locationName) {

        this.locationType = locationType;
        this.locationName = locationName;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public LocationName getLocationName() {
        return locationName;
    }

    @Override
    public boolean isSameAs(PlaceOfOffence other) {

        return other != null && new EqualsBuilder().
                append(this.locationType, other.locationType).
                append(this.locationName, other.locationName).
                isEquals();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof PlaceOfOffence)) return false;
        return this.isSameAs((PlaceOfOffence) o);
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().
                append(this.locationType).
                append(this.locationName).
                toHashCode();
    }

    @Override
    public String toString() {
        return "PlaceOfOffence{" +
                "locationType=" + locationType +
                ", locationName=" + locationName +
                '}';
    }
}
