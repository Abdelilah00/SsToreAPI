package com.SsTore.Dtos.Product.ShippingMethods;////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////


import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippingMethodCreateDto extends BaseDto {
    private String name;
}
