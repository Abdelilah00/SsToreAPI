////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * 
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class ProductReviews extends BaseEntity {


    public Long stars;

    public String review;

    public Boolean helpful;

    @OneToOne
    private Product product;

}
