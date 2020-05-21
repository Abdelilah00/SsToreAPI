////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers;

import com.SsTore.Dtos.Customers.CustomerCreateDto;
import com.SsTore.Dtos.Customers.CustomerDto;
import com.SsTore.Dtos.Customers.CustomerUpdateDto;
import com.SsTore.domains.Customer;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/customers")
public class CustomersController extends BaseCrudController<Customer, CustomerDto, CustomerCreateDto, CustomerUpdateDto> {

}
