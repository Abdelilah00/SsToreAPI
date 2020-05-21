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
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class InvoiceDetails extends BaseEntity {
    private static final long serialVersionUID = -19327445457556L;
    @NotBlank
    private String name;
    @Min(0)
    @NotNull
    private int qtySealed;

    @ManyToOne
    private Invoice invoice;
    @OneToOne
    private Product product;
}
