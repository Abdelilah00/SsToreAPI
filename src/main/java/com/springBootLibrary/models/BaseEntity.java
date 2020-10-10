////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.springBootLibrary.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.*;

import javax.persistence.MappedSuperclass;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
@FilterDef(
        name = "tenantFilter",
        parameters = @ParamDef(name = "tenantId", type = "long")
)
@Filter(
        name = "tenantFilter",
        condition = "tenantId = :tenantId"
)

@FilterDef(
        name = "deleteFilter",
        parameters = @ParamDef(name = "deletedAt", type = "LocalDateTime")
)
@Filter(
        name = "deleteFilter",
        condition = "deletedAt = :deletedAt"
)
public abstract class BaseEntity extends IdEntity {
    private long tenantId;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt = null;

    private long createdBy;
    private long updatedBy;
    private long deletedBy;
}

