package com.SsTore.Dtos.Order.Orders;

import com.SsTore.Dtos.Order.OrderDetails.OrderDetailsDto;
import com.SsTore.domains.Order.Order;
import com.SsTore.domains.Order.OrderDetails;
import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    private List<OrderDetailsDto> orderDetails;
}
