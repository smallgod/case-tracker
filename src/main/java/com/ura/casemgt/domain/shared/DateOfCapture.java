package com.ura.casemgt.domain.shared;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author smallGod
 **/
public final class DateOfCapture implements ValueObject<DateOfCapture> {

    private final LocalDate date;

    public DateOfCapture(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public boolean isSameAs(DateOfCapture other) {
        return other != null && this.getDate().equals(other.getDate());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof DateOfCapture)) return false;
        return this.isSameAs((DateOfCapture) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getDate());
    }
}
