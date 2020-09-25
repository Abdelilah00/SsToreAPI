////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Order;


import com.SsTore.Dtos.Order.OrderCreateDto;
import com.SsTore.Dtos.Order.OrderDto;
import com.SsTore.Dtos.Order.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/admin/orders")
public class OrdersController extends BaseCrudController<Order, OrderDto, OrderCreateDto, OrderUpdateDto> {
}

