////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains;

import com.springBootLibrary.models.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Invoice extends BaseEntity {
    private static final long serialVersionUID = -1938567246027507296L;

    private String name;
    @ManyToOne
    private Customer customer;
}
