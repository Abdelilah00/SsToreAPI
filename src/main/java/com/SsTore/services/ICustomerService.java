////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.Customers.CustomerCreateDto;
import com.SsTore.Dtos.Customers.CustomerDto;
import com.SsTore.Dtos.Customers.CustomerUpdateDto;
import com.springBootLibrary.services.IBaseCrudService;

public interface ICustomerService extends IBaseCrudService<Customer, CustomerDto, CustomerCreateDto, CustomerUpdateDto> {

}
