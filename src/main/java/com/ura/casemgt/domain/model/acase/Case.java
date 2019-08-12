package com.ura.casemgt.domain.model.acase;

import com.ura.casemgt.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.time.LocalDateTime;


/**
 * @author smallGod
 **/
public class Case implements ValueObject<Case> {

    private final LocalDateTime openningDate;
    private final CaseCategory caseCategory;
    private final Subject subject;
    private final CaseSummary caseSummary;
    private final BriefFacts briefFacts;
    private final PlaceOfOffence placeOfOffence;

    public Case(LocalDateTime openningDate,
                CaseCategory caseCategory,
                Subject subject,
                CaseSummary caseSummary,
                BriefFacts briefFacts,
                PlaceOfOffence placeOfOffence) {

        Validate.noNullElements(new Object[]{caseCategory, subject, placeOfOffence});

        this.openningDate = openningDate;
        this.caseCategory = caseCategory;
        this.subject = subject;
        this.caseSummary = caseSummary;
        this.briefFacts = briefFacts;
        this.placeOfOffence = placeOfOffence;
    }

    public LocalDateTime getOpenningDate() {
        return openningDate;
    }

    public CaseCategory getCaseCategory() {
        return caseCategory;
    }

    public Subject getSubject() {
        return subject;
    }

    public CaseSummary getCaseSummary() {
        return caseSummary;
    }

    public BriefFacts getBriefFacts() {
        return briefFacts;
    }

    public PlaceOfOffence getPlaceOfOffence() {
        return placeOfOffence;
    }

    @Override
    public boolean isSameAs(Case other) {

        return other != null && new EqualsBuilder().
                append(this.openningDate, other.openningDate).
                append(this.caseCategory, other.caseCategory).
                append(this.subject, other.subject).
                append(this.caseSummary, other.caseSummary).
                append(this.briefFacts, other.briefFacts).
                append(this.placeOfOffence, other.placeOfOffence).
                isEquals();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Case)) return false;
        return this.isSameAs((Case) o);
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder().
                append(this.openningDate).
                append(this.caseCategory).
                append(this.subject).
                append(this.caseSummary).
                append(this.briefFacts).
                append(this.placeOfOffence).
                toHashCode();
    }

    @Override
    public String toString() {
        return "Case{" +
                " openningDate=" + openningDate +
                ", caseCategory=" + caseCategory +
                ", subject=" + subject +
                ", caseSummary=" + caseSummary +
                ", briefFacts=" + briefFacts +
                ", placeOfOffence=" + placeOfOffence +
                '}';
    }
}
