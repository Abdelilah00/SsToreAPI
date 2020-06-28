////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Products;

import com.SsTore.Dtos.Characteristics.CharacteristicDto;
import com.SsTore.Dtos.Specifications.SpecificationDto;
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
    private Float price;
    private Long qte;

    /*
        private MultipartFile images;
    */
    private List<Long> tagsId = new ArrayList<>();
    private List<Long> categoriesId = new ArrayList<>();
    private List<Long> wareHouseId = new ArrayList<>();
    private List<Long> shippingMethodsId = new ArrayList<>();

    private List<CharacteristicDto> characteristics = new ArrayList<>();
    private List<SpecificationDto> specifications = new ArrayList<>();
}
