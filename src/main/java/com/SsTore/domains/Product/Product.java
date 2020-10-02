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

    private String comment;

    private Float salePrice = 0F;

    private Long qte = 0L;

    private Boolean newest = true;

    @Column(length = Integer.MAX_VALUE)
    private String overview = "";

    //One To Many
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Specification> specifications = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Image> images = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Solde solde;

    //Many to Many
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductCategories> productCategories = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductTags> productTags = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductCharacteristic> productCharacteristics = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductShippedBy> productShippedBy = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductIn> productInList = new ArrayList<>();


    //TODO : Link this with Accounts
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Reviews> reviews = new ArrayList<>();

    //TODO : Stock Qte @Formula
    //@Formula("select (p.qte - SUM(o.qte)) stockQte from product p inner join orderdetails o on p.id = o.product_id where p.id=1")
    //@Transient
    //private Long stockQte;
}
