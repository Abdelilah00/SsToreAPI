////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.repositorys.Product;

import com.SsTore.domains.Product.Product;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends IBaseJpaRepository<Product> {
    @Query("select p from Product p inner join ProductCategories pg on p.id = pg.product.id where pg.category.id=:categoryId")
    List<Product> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query("select p from Product p inner join ProductCategories pg on p.id = pg.product.id where pg.category.parent.id=:categoryId")
    List<Product> findByCategoryParentId(@Param("categoryId") Long categoryId);

    List<Product> findByNameContains(String query);

    //TODO: return names only
    List<Product> findNameByNameContains(String query);
}

