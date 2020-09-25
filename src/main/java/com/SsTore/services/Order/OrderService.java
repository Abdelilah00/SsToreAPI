////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Order;

import com.SsTore.Dtos.Order.OrderCreateDto;
import com.SsTore.Dtos.Order.OrderDto;
import com.SsTore.Dtos.Order.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.SsTore.Dtos.Order.OrderCreateDto;
import com.SsTore.Dtos.Order.OrderDto;
import com.SsTore.Dtos.Order.OrderUpdateDto;
import com.SsTore.domains.Order.Order;

@Service
public class OrderService extends BaseCrudServiceImpl<Order, OrderDto, OrderCreateDto, OrderUpdateDto> implements IOrderService {
    public OrderService() {
        super(Order.class, OrderDto.class, OrderCreateDto.class, OrderUpdateDto.class);
    }


}

