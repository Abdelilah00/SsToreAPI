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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderdetails")
public class OrderDetails extends BaseEntity {
    @NotNull
    @NotEmpty
    public Long qte;
    @NotNull
    @NotEmpty
    public Float price;

    //TODO: Value tables
    //@OneToOne
    //private ProductCharacteristic productCharacteristic = new ProductCharacteristic();

    @OneToOne
    private Product product = new Product();

    @ManyToOne
    private Order order = new Order();
}
