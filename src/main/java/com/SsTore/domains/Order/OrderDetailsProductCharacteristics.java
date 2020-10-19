package com.SsTore.domains.Order;

import com.SsTore.domains.Product.ProductCharacteristic;
import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details_product_characteristics")
public class OrderDetailsProductCharacteristics extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    private OrderDetails orderDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProductCharacteristic productCharacteristic;
}
