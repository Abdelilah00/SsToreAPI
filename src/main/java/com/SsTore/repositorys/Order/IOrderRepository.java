////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.repositorys.Order;

import com.SsTore.domains.Order.Order;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends IBaseJpaRepository<Order> {
    @Query("select (COUNT(o)>0) as ordred from Order o inner join OrderDetails od on o.id= od.order.id where o.customer.email=:customerEmail and od.product.id=:productId")
    boolean isAlreadyOrdered(@Param("customerEmail") String customerEmail, @Param("productId") Long productId);
}
