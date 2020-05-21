////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {
    private static final long serialVersionUID = -193857221212507296L;
    @NotBlank
    private String name;
    @Min(0)
    @NotNull
    private Long qtyStock;

    /*@OneToMany
    @JsonBackReference
    @Fetch(FetchMode.JOIN)
    private List<InvoiceDetails> invoiceDetails = new ArrayList<>();*/

    @ManyToOne
    @JsonManagedReference
    private Store store;

}
