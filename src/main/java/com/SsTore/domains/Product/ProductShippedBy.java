////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_shippedby")
public class ProductShippedBy extends BaseEntity {
    @ManyToOne
    private Product product;

    @ManyToOne
    private ShippingMethod shippingMethod = new ShippingMethod();

    @OneToOne
    private ShippingCountry shippingCountry = new ShippingCountry();

    private Float amount;
}

