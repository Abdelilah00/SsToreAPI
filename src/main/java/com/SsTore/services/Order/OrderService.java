////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Order;

import com.SsTore.Dtos.Order.OrderCreateDto;
import com.SsTore.Dtos.Order.OrderDto;
import com.SsTore.Dtos.Order.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.SsTore.domains.Order.OrderDetails;
import com.SsTore.repositorys.Order.IOrderRepository;
import com.SsTore.repositorys.Product.IProductRepository;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class OrderService extends BaseCrudServiceImpl<Order, OrderDto, OrderCreateDto, OrderUpdateDto> implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;

    public OrderService() {
        super(Order.class, OrderDto.class, OrderCreateDto.class, OrderUpdateDto.class);
    }

    @Override
    public CompletableFuture<OrderDto> create(OrderCreateDto orderCreateDto) {
        var order = objectMapper.convertToEntity(orderCreateDto);

        order.setOrderDetails(orderCreateDto.getOrderDetails().stream().map(orderDetail -> {
            var od = new OrderDetails();
            od.getProduct().setId(orderDetail.getProductId());
            od.setQte(orderDetail.getQte());
            od.setPrice(orderDetail.getPrice());
            od.setOrder(order);
            return od;
        }).collect(Collectors.toList()));

        iOrderRepository.save(order);
        return CompletableFuture.completedFuture(objectMapper.convertToDto(order, OrderDto.class));
    }
}

