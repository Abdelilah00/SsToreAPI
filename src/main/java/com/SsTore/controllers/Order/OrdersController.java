////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Order;


import com.SsTore.Dtos.Order.Orders.OrderCreateDto;
import com.SsTore.Dtos.Order.Orders.OrderDto;
import com.SsTore.Dtos.Order.Orders.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/orders")
public class OrdersController extends BaseCrudController<Order, OrderDto, OrderCreateDto, OrderUpdateDto> {
}

