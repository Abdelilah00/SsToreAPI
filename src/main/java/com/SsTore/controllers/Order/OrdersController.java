////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Order;


import com.SsTore.Dtos.Order.Orders.OrderCreateDto;
import com.SsTore.Dtos.Order.Orders.OrderDto;
import com.SsTore.Dtos.Order.Orders.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.configuration.Exception.UserFriendlyException;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/admin/orders")
public class OrdersController extends BaseCrudController<Order, OrderDto, OrderCreateDto, OrderUpdateDto> {
    @Qualifier("getWebClientBuilder")
    @Autowired
    private WebClient.Builder webClient;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    protected OrderDto create(@Valid @RequestBody OrderCreateDto dto) throws ExecutionException, InterruptedException, UserFriendlyException, IOException, MessagingException {

        var tmp = super.create(dto);

        webClient.baseUrl("http://localhost:8081/").build()
                .post().uri("orderConfirmation/" + tmp.getCustomerEmail())
                .retrieve();

        return tmp;
    }
}

