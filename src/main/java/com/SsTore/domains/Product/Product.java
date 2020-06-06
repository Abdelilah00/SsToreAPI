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

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    private String name;

    private String description;

    private Float price;

    private Long qte;

    private String overview;

    //One To Many
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Specification> specifications = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Image> images = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Solde solde;

    //Many to Many
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
    private List<ProductCategories> productCategories = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shippingMethod")
    private List<ProductShippedBy> productShippedByList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tag")
    private List<ProductTags> productTags = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "characteristic")
    private List<ProductCharacteristic> productCharacteristics = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wareHouse")
    private List<ProductIn> productInList = new ArrayList<>();

    //TODO : Link this with Accounts
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductReviews> productReviews = new ArrayList<>();

    //TODO : Qte disponible
}
