////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.Customers.CustomerCreateDto;
import com.SsTore.Dtos.Customers.CustomerDto;
import com.SsTore.Dtos.Customers.CustomerUpdateDto;
import com.SsTore.domains.Customer;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseCrudServiceImpl<Customer, CustomerDto, CustomerCreateDto, CustomerUpdateDto> implements ICustomerService {
    public CustomerService() {
        super(Customer.class, CustomerDto.class, CustomerCreateDto.class, CustomerUpdateDto.class);
    }

}
