package com.SsTore.domains.Account;

import com.SsTore.domains.Product.Product;
import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "wishList")
public class WishList extends BaseEntity {

    @OneToOne
    private Customer customer;

    @OneToOne
    private Product product;
}
