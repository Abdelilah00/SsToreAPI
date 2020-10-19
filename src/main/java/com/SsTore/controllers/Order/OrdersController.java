////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Order;


import com.SsTore.Dtos.Order.Orders.OrderCreateDto;
import com.SsTore.Dtos.Order.Orders.OrderDto;
import com.SsTore.Dtos.Order.Orders.OrderUpdateDto;
import com.SsTore.domains.Order.Order;
import com.SsTore.services.utils.Emails.IEmailService;
import com.configuration.Exception.UserFriendlyException;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/admin/orders")
public class OrdersController extends BaseCrudController<Order, OrderDto, OrderCreateDto, OrderUpdateDto> {
    @Autowired
    IEmailService iEmailService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    protected OrderDto create(@Valid @RequestBody OrderCreateDto dto) throws ExecutionException, InterruptedException, UserFriendlyException, IOException, MessagingException {
        //TODO: check with PAYPAL payment
        var tmp = super.create(dto);

        try {
            iEmailService.sendOrderEmail(tmp.getCustomerEmail());
        } catch (Exception ignored) {

        }
        return tmp;
    }
}

