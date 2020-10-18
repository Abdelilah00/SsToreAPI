////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.SsTore.domains.Order.OrderDetails;
import com.springBootLibrary.models.BaseEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_characteristic")
public class ProductCharacteristic extends BaseEntity {

    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product = new Product();

    @ManyToOne(cascade = CascadeType.ALL)
    private Characteristic characteristic = new Characteristic();

}
