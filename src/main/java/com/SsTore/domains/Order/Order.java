package com.SsTore.domains.Order;

import com.SsTore.domains.Account.Customer;
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
@Table(name = "OrderGlobal")
public class Order extends BaseEntity {

    public String shippingAdresse;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @OneToOne
    private Customer customer;
}
