package com.SsTore.repositorys;

import com.SsTore.domains.Product;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends IBaseJpaRepository<Product> {

}
