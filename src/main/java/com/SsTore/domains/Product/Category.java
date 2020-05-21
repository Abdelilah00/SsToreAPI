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
public class Category extends BaseEntity {

    /**
     * Default constructor
     */
    public Category() {
    }

    /**
     * 
     */
    public String name;


}
