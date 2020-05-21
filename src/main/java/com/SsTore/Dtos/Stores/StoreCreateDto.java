package com.SsTore.Dtos.Stores;

import com.SsTore.Dtos.Products.ProductDto;
import com.springBootLibrary.models.BaseDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class StoreCreateDto extends BaseDto {
    private String name;

    private List<ProductDto> products = new ArrayList<>();
}
