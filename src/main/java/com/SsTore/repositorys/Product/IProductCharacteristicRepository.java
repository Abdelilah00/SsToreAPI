////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.repositorys.Product;

import com.SsTore.domains.Product.ProductCharacteristic;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductCharacteristicRepository extends IBaseJpaRepository<ProductCharacteristic> {
    ProductCharacteristic findByCharacteristicNameAndValueAndProductId(String characteristicName, String value, Long productId);
}
