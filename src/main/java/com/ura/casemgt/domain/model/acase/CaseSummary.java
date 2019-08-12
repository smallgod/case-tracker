package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.ValueObject;

import java.util.Objects;

/**
 * @author smallGod
 **/
public final class CaseSummary implements ValueObject<CaseSummary> {

    private final String text;

    public CaseSummary(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public boolean isSameAs(CaseSummary other) {
        return other != null && this.getText()
                .equals(other.getText());
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof CaseSummary)) return false;
        return this.isSameAs((CaseSummary) o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getText());
    }
}
