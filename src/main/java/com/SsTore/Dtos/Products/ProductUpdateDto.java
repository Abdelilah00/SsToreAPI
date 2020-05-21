////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Products;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDto extends BaseDto {
    public String name;

    public String description;

    public Float price;

    public Long qte;
}
