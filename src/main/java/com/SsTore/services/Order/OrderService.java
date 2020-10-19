////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Order;

import com.SsTore.Dtos.Order.Orders.OrderCreateDto;
import com.SsTore.Dtos.Order.Orders.OrderDto;
import com.SsTore.Dtos.Order.Orders.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.SsTore.domains.Order.OrderDetails;
import com.SsTore.domains.Order.OrderDetailsProductCharacteristics;
import com.SsTore.repositorys.Order.IOrderRepository;
import com.SsTore.repositorys.Product.IProductCharacteristicRepository;
import com.SsTore.repositorys.Product.IProductRepository;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class OrderService extends BaseCrudServiceImpl<Order, OrderDto, OrderCreateDto, OrderUpdateDto> implements IOrderService {
    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private IProductCharacteristicRepository iProductCharacteristicRepository;


    public OrderService() {
        super(Order.class, OrderDto.class, OrderCreateDto.class, OrderUpdateDto.class);
    }

    @Override
    public CompletableFuture<OrderDto> create(OrderCreateDto orderCreateDto) {
        var order = objectMapper.convertToEntity(orderCreateDto);

        //get orderDetailsProductCharacteristics by selectedCharacteristics and set it to orderDetails
        var orderDetailsList = orderCreateDto.getOrderDetails().stream().map(orderDetailsDto -> {
            var od = new OrderDetails();
            od.getProduct().setId(orderDetailsDto.getProductId());
            od.setQte(orderDetailsDto.getQte());
            od.setPrice(iProductRepository.findById(orderDetailsDto.getProductId()).get().getPrice());
            if (orderDetailsDto.getSelectedCharacteristics() != null)
                od.setOrderDetailsProductCharacteristics(
                        orderDetailsDto.getSelectedCharacteristics().stream().map(selectedCharacteristicsDto -> {
                                    var orderDetailsProductCharacteristics = new OrderDetailsProductCharacteristics();
                                    var tmp = iProductCharacteristicRepository.findByCharacteristicNameAndValueAndProductId(selectedCharacteristicsDto.getName(), selectedCharacteristicsDto.getValue(), orderDetailsDto.getProductId());
                                    orderDetailsProductCharacteristics.setProductCharacteristic(tmp);
                                    orderDetailsProductCharacteristics.setOrderDetails(od);
                                    return orderDetailsProductCharacteristics;
                                }
                        ).collect(Collectors.toList()));

            od.setOrder(order);
            return od;
        }).collect(Collectors.toList());

        order.setOrderDetails(orderDetailsList);


        iOrderRepository.save(order);

        return CompletableFuture.completedFuture(objectMapper.convertToDto(order, OrderDto.class));
    }
}

