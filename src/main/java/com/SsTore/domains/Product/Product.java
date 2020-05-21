////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * 
 */
@Entity
@Data
public class Product extends BaseEntity {

    /**
     * Default constructor
     */
    public Product() {
    }

    /**
     * 
     */
    public String name;

    /**
     * 
     */
    public String description;

    /**
     * 
     */
    public Float price;

    /**
     * 
     */
    public Long qte;












}
