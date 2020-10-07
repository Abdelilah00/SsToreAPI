package com.SsTore.repositorys.Product;

import com.SsTore.domains.Product.ShippingCountry;
import com.SsTore.domains.Product.ShippingMethod;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShippingCountryRepository extends IBaseJpaRepository<ShippingCountry> {
}
