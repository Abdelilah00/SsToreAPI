////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Order;

import com.SsTore.Dtos.Order.OrderDetails.OrderDetailsDto;
import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateDto extends BaseDto {
    private String customerFirstName;
    private String customerLastName;
    private String customerPhoneNumber;
    private String customerEmail;
    private String customerAddress;
    private String customerCountry;
    private String customerState;
    private String customerCity;
    private String customerZip;

    private List<OrderDetailsDto> orderDetails;
}

