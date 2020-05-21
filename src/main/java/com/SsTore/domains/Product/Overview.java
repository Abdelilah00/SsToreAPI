////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import lombok.Data;

import javax.persistence.Entity;

/**
 * 
 */
@Entity
@Data
public class Overview {

    /**
     * Default constructor
     */
    public Overview() {
    }

    /**
     * 
     */
    public String discription;


}
