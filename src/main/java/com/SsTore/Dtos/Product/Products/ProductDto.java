////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Product.Products;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductDto extends BaseDto {

    private String name;
    private String overview;
    private String comment;
    private Float price;
    private Long qte;
    private List<Image> images = new ArrayList<>();
    private String imageCover;
    private boolean newest;
    private boolean sale;

/*  private List<Long> tagsId = new ArrayList<>();
    private List<Long> categoriesId = new ArrayList<>();
    private List<Long> wareHouseId = new ArrayList<>();
    private List<Long> shippingMethodsId = new ArrayList<>();

    private List<CharacteristicDto> characteristics = new ArrayList<>();
    private List<SpecificationDto> specifications = new ArrayList<>();*/
}

