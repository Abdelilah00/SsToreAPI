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
public abstract class BaseEntity extends IdEntity {
    private long tenantId;

    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private Date deletedAt = null;

    private long createdBy;
    private long updatedBy;
    private long deletedBy;
}

