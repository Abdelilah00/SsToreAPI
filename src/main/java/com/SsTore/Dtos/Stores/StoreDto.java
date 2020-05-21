////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Stores;

import com.SsTore.Dtos.Products.ProductDto;
import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StoreDto extends BaseDto {
    private String name;

    private List<ProductDto> products = new ArrayList<>();
}

