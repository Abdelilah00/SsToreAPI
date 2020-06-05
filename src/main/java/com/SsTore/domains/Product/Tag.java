////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

/**
 *
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tag extends BaseEntity {

    private String name;

/*    @ManyToMany(mappedBy = "tags")
    private List<Product> product = new ArrayList<>();*/

}
