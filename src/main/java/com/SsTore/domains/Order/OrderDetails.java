package com.SsTore.domains.Order;

import com.SsTore.domains.Product.Product;
import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails extends BaseEntity {
    public Long qte;
    public Float price;

    @OneToOne
    private Product product = new Product();

    @ManyToOne
    private Order order = new Order();
}
