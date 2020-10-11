////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.repositorys.Product;

import com.SsTore.domains.Account.Customer;
import com.SsTore.domains.Product.Category;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends IBaseJpaRepository<Category> {
    List<Category> findByName(String name);

    @Query("select c from Category c inner join ProductCategories pg on c.id = pg.category.id where pg.product.id=:productId")
    List<Category> findByProductId(Long productId);

    List<Category> findByParentIdIsNull();

    List<Category> findByParentId(Long parentId);
}

