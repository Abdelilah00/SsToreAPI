package com.SsTore.domains.Order;

import com.SsTore.domains.Product.Product;
import com.SsTore.domains.Product.ProductCharacteristic;
import com.springBootLibrary.models.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
@Table(name = "order_details")
public class OrderDetails extends BaseEntity {
    @NotNull
    public Long qte;

    @NotNull
    public Float price;

    //TODO: Value tables
    //@OneToOne
    //private ProductCharacteristic productCharacteristic = new ProductCharacteristic();

    @OneToOne
    private Product product = new Product();

    @ManyToOne
    private Order order = new Order();

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductCharacteristic> productCharacteristics = new ArrayList<>();
}
