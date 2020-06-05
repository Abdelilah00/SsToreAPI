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

    public String name;

    public String description;

    public Float price;

    public Long qte;

    private String overview;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Specification> specifications = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Image> images = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ProductTags")
    private List<Tag> tags = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ProductCategories")
    private List<Category> categories;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ProductCharacteristic")
    private List<Characteristic> characteristic = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductReviews> productReviews = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
    private Solde solde;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ProductIn")
    private List<WareHouse> wareHouses = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ProductShippedBy")
    private List<ShippingMethods> shippingMethods = new ArrayList<>();

    //TODO : Qte disponible
}
