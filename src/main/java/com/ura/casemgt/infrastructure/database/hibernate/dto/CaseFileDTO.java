package com.ura.casemgt.infrastructure.database.hibernate.dto;

import com.ura.casemgt.domain.model.acase.CaseCategory;
import com.ura.casemgt.domain.model.acase.LocationOfFile;
import com.ura.casemgt.domain.model.acase.Status;
import org.hibernate.annotations.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "c_case_file", uniqueConstraints = @UniqueConstraint(
        columnNames ={"gef_reference"}))
@NamedQueries({
        @NamedQuery(name = CaseFileDTO.FETCH_CASE_BY_ID,
                query = CaseFileDTO.FETCH_CASE_BY_ID_QUERY)
})
/**
 * @author smallGod
 */
public class CaseFileDTO extends BaseEntity {

    public static final String FETCH_CASE_BY_ID = "FETCH_CASE_BY_ID";
    public static final String FETCH_CASE_BY_ID_QUERY = "SELECT DISTINCT aCase FROM CaseFileDTO aCase where aCase.id IN (:id)";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "gef_reference", nullable = false)
    private String gefReferenceNumber;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private CaseCategory category;

    @Column(name = "brief_facts", length = 20000)
    private String briefFacts;

    @Embedded
    private PlaceOfOffenceEmbeddable placeOfOffence;

    @Column(name = "openning_date", nullable = false)
    private LocalDateTime openningDate;

    @Column(name = "subject")
    private String subject;

    @Column(name = "summary")
    private String summary;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "location_of_file")
    @Enumerated(EnumType.STRING)
    private LocationOfFile locationOfFile;

    public CaseFileDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CaseCategory getCategory() {
        return category;
    }

    public void setCategory(CaseCategory category) {
        this.category = category;
    }

    public String getBriefFacts() {
        return briefFacts;
    }

    public void setBriefFacts(String briefFacts) {
        this.briefFacts = briefFacts;
    }

    public LocalDateTime getOpenningDate() {
        return openningDate;
    }

    public void setOpenningDate(LocalDateTime openningDate) {
        this.openningDate = openningDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocationOfFile getLocationOfFile() {
        return locationOfFile;
    }

    public void setLocationOfFile(LocationOfFile locationOfFile) {
        this.locationOfFile = locationOfFile;
    }

    public String getGefReferenceNumber() {
        return gefReferenceNumber;
    }

    public void setGefReferenceNumber(String gefReferenceNumber) {
        this.gefReferenceNumber = gefReferenceNumber;
    }

    public PlaceOfOffenceEmbeddable getPlaceOfOffence() {
        return placeOfOffence;
    }

    public void setPlaceOfOffence(PlaceOfOffenceEmbeddable placeOfOffence) {
        this.placeOfOffence = placeOfOffence;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseFileDTO caseFile = (CaseFileDTO) o;
        return getId() == caseFile.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "CaseFileDTO{" +
                "id=" + id +
                ", gefReferenceNumber=" + gefReferenceNumber +
                ", briefFacts='" + briefFacts + '\'' +
                ", openningDate=" + openningDate +
                ", subject='" + subject + '\'' +
                ", summary='" + summary + '\'' +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}
