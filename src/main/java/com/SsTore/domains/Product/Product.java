////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    public String name;

    public String description;

    public Float price;

    public Long qte;

    @OneToOne(mappedBy = "product")
    private Overview overview;

    @OneToMany(mappedBy = "product")
    private List<Specification> specification = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Images> images = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ProductTags")
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ProductCategorys")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ProductCharacteristic")
    private List<Characteristic> characteristic = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductReviews> productReviews = new ArrayList<>();

    @OneToOne(mappedBy = "product")
    private Solde solde;

    @OneToMany(mappedBy = "product")
    private List<WareHouse> wareHouse = new ArrayList<>();

    //TODO : Qte disponible
}
