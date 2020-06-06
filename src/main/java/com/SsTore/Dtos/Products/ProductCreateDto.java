////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Products;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class SpecificationDto {
    private String name;
    private String value;
}

@Getter
@Setter
class CharacteristicDto {
    private String name;
    private List<String> values = new ArrayList<>();
}

@Getter
@Setter
class ProductReviewsDto {
    private Long stars;
    private String review;
    private Boolean helpful;
}

@Getter
@Setter
class Name {
    private String name;
}
@Getter
@Setter
public class ProductCreateDto extends BaseDto {

    private String name;
    private String overview;
    private String comment;
    private Float price;
    private Long qte;

    // private List<MultipartFile> images;

    private List<String> images = new ArrayList<>();
    private List<Long> tagsId = new ArrayList<>();
    private List<Long> categoriesId = new ArrayList<>();
    private List<Long> wareHouseId = new ArrayList<>();
    private List<Long> shippingMethodsId = new ArrayList<>();

    private List<CharacteristicDto> characteristics = new ArrayList<>();
    private List<SpecificationDto> specifications = new ArrayList<>();
}
