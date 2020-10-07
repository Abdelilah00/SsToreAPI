package com.SsTore.Dtos.Order.Orders;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderUpdateDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String emailAddresse;
    private String country;
    private String state;
    private String city;
    private String zip;
}
