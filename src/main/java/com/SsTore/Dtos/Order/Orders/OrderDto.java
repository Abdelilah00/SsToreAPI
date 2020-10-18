package com.SsTore.Dtos.Order.Orders;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto extends BaseDto {
    private String customerFirstName;
    private String customerLastName;
    private String customerPhoneNumber;
    private String customerEmail;
    private String customerAddress;
    private String customerCity;
    private String customerZip;
}
