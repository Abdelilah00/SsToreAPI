////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.domains.Product;

import com.springBootLibrary.models.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Entity
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "characteristic")
public class Characteristic extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "characteristic")
    private List<ProductCharacteristic> productCharacteristics = new ArrayList<>();

    public List<String> getValues() {
        return productCharacteristics.stream().map(ProductCharacteristic::getValue).collect(Collectors.toList());
    }

}
