package com.SsTore.Dtos.Product.ShippedBy;////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////


import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShippedByCreateDto extends BaseDto {
    private Long shippingCountryId;
    private Long shippingMethodId;
    private Float amount;
}
