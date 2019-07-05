package com.ura.casemgt.domain.shared;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class EmailAddress implements ValueObject<EmailAddress> {

    private final String address;

    public EmailAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public boolean isSameAs(EmailAddress other) {
        return other != null && this.getAddress().equals(other.getAddress());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof EmailAddress)) return false;
        return this.isSameAs((EmailAddress) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAddress());
    }
}
