////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.repositorys.Product;

import com.SsTore.domains.Product.Reviews;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewsRepository extends IBaseJpaRepository<Reviews> {
    @Query("select (count(r) > 0) as reviewed from Reviews r where r.customer.id=:customerId and r.product.id=:productId ")
    boolean isAlreadyReviewed(@Param("customerId") Long customerId, @Param("productId") Long productId);
}
