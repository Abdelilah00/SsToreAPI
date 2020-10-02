////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCharacteristic extends BaseEntity {

    @ElementCollection
    private List<String> value = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product = new Product();

    @ManyToOne(cascade = CascadeType.ALL)
    private Characteristic characteristic = new Characteristic();
}
