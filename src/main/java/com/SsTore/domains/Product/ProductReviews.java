////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;

import java.util.*;

/**
 * 
 */
public class ProductReviews extends BaseEntity {

    /**
     * Default constructor
     */
    public ProductReviews() {
    }

    /**
     * 
     */
    public Long stars;

    /**
     * 
     */
    public String review;

    /**
     * 
     */
    public Boolean helpful;

}
