package com.SsTore.domains.Order;

import com.SsTore.domains.Account.Customer;
import com.SsTore.domains.Product.ProductCharacteristic;
import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`order`")
public class Order extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
