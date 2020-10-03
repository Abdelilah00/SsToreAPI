////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Formula;

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

    private Float salePrice = 0.0F;

    private Long qte = 0L;

    private boolean newest = true;

    @Column(length = Integer.MAX_VALUE)
    private String overview = "";

    //One To Many
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Discount discount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Specification> specifications = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Image> images = new ArrayList<>();


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


    public boolean getOnSale() {
        return discount != null;
    }

    @Formula("(select p.qte - IFNULL(SUM(o.qte), 0) from product p inner join orderdetails o on p.id = o.product_id where p.id = id)")
    private Long stockQte;

    //TODO: using @Formula
    public Float getPrice() {
        if (getOnSale()) return salePrice - discount.getPercent() * salePrice;
        return salePrice;
    }
}
