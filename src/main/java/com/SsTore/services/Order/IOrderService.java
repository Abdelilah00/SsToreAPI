////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Order;


import com.SsTore.Dtos.Order.OrderCreateDto;
import com.SsTore.Dtos.Order.OrderDto;
import com.SsTore.Dtos.Order.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.springBootLibrary.services.IBaseCrudService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IOrderService extends IBaseCrudService<Order, OrderDto, OrderCreateDto, OrderUpdateDto> {

}
