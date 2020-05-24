////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Products;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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
public class ProductCreateDto extends BaseDto {

    private String name;
    private String description;
    private Float price;
    private Long qte;

    private List<MultipartFile> images;

    private String overviewDiscription;

    private List<SpecificationDto> specifications;

    private List<String> tagsName = new ArrayList<>();

    private List<String> categoriesName;

    private List<CharacteristicDto> characteristic = new ArrayList<>();

    private List<String> wareHouse = new ArrayList<>();
}
