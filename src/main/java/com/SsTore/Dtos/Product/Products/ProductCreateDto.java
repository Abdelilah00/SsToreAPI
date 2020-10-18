////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Product.Products;

import com.SsTore.Dtos.Product.Characteristics.CharacteristicCreateDto;
import com.SsTore.Dtos.Product.ShippedBy.ShippedByCreateDto;
import com.SsTore.Dtos.Product.Specifications.SpecificationCreateDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductCreateDto extends BaseDto {

    private String name;
    private String overview;
    private String comment;
    private Float salePrice;
    private Long initQte;
    private String videoLink;

    @JsonIgnoreProperties
    private List<String> images = new ArrayList<>();

    private List<Long> tagsId = new ArrayList<>();
    private List<Long> categoriesId = new ArrayList<>();
    private List<Long> wareHousesId = new ArrayList<>();

    private List<CharacteristicCreateDto> characteristics = new ArrayList<>();
    private List<SpecificationCreateDto> specifications = new ArrayList<>();

    private List<ShippedByCreateDto> shippedBy = new ArrayList<>();
}
