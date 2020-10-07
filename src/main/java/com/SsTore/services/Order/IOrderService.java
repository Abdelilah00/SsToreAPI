////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Order;


import com.SsTore.Dtos.Order.Orders.OrderCreateDto;
import com.SsTore.Dtos.Order.Orders.OrderDto;
import com.SsTore.Dtos.Order.Orders.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.springBootLibrary.services.IBaseCrudService;

public interface IOrderService extends IBaseCrudService<Order, OrderDto, OrderCreateDto, OrderUpdateDto> {

}
