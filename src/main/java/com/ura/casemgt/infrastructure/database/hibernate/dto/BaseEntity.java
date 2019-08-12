/*
 * Copyright (c) 2019. smallGod.
 * This code is provided as is and is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 */
package com.ura.casemgt.infrastructure.database.hibernate.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.ura.casemgt.domain.shared.DatabaseEntity;
import com.ura.casemgt.infrastructure.database.Auditable;


/**
 * @author smallGod
 */
//@TypeDefs({
//        @TypeDef(name = "jodalocaldatetime", typeClass = PersistentLocalDateTime.class,
//                parameters = {
//                        @Parameter(value = "UTC", name = "databaseZone"),
//                        @Parameter(value = "UTC", name = "javaZone")
//                }
//        ),
//        @TypeDef(name = "jodalocaldate", typeClass = PersistentLocalDate.class,
//                parameters = {
//                        @Parameter(value = "UTC", name = "databaseZone"),
//                        @Parameter(value = "UTC", name = "javaZone")
//                }
//        ),
//        @TypeDef(name = "jodalocaltime", typeClass = PersistentLocalTime.class,
//                parameters = {
//                        @Parameter(value = "UTC", name = "databaseZone"),
//                        @Parameter(value = "UTC", name = "javaZone")
//                }
//        )
//})
@MappedSuperclass
public abstract class BaseEntity
        implements Auditable, Serializable, DatabaseEntity {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on", updatable = false, nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "date_last_modified")
    private LocalDateTime dateLastModified;

    @Column(name = "date_modified_history", length = 7000)
    private String dateModifiedHistory; // '|' separated strings

    @Column(name = "modified_by_history", length = 7000)
    private String modifiedByHistory; // '|' separated strings

    @Column(name = "description")
    private String description;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(LocalDateTime dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    public String getDateModifiedHistory() {
        return dateModifiedHistory;
    }

    public void setDateModifiedHistory(String dateModifiedHistory) {
        this.dateModifiedHistory = dateModifiedHistory;
    }

    public String getModifiedByHistory() {
        return modifiedByHistory;
    }

    public void setModifiedByHistory(String modifiedByHistory) {
        this.modifiedByHistory = modifiedByHistory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}