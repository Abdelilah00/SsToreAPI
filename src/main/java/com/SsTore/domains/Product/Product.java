////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * 
 */

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@Entity
@AllArgsConstructor
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
