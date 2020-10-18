////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Product.Products;

import com.SsTore.Dtos.Product.Characteristics.CharacteristicDto;
import com.SsTore.Dtos.Product.Discounts.DiscountDto;
import com.SsTore.Dtos.Product.Images.ImageDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsDto;
import com.SsTore.Dtos.Product.ShippedBy.ShippedByDto;
import com.SsTore.Dtos.Product.Specifications.SpecificationDto;
import com.SsTore.Dtos.Product.Tags.TagDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductDto extends BaseDto {
    @JsonIgnore
    private final String uploadDirOut = "http://localhost:8080/images/";

    private String name;
    private String overview;
    private String comment;
    private Float price;
    private Float salePrice;
    private String imageCover;
    private String videoLink;
    private boolean newest;

    private DiscountDto discount;
    private boolean onSale;

    private Long stockQte;
    private Long initQte;
    private Float starsGlobal;


    private List<ReviewsDto> reviews = new ArrayList<>();
    private List<ImageDto> images = new ArrayList<>();
    private List<CharacteristicDto> productCharacteristics = new ArrayList<>();
    private List<TagDto> productTags = new ArrayList<>();

    //private List<Long> categoriesId = new ArrayList<>();
    //private List<Long> wareHouseId = new ArrayList<>();
    private List<ShippedByDto> productShippedBy = new ArrayList<>();
    private List<SpecificationDto> specifications = new ArrayList<>();

    public List<ImageDto> getImages() {
        images = images.stream().map(image -> {
            image.setUrl(uploadDirOut + image.getName());
            return image;
        }).collect(Collectors.toList());
        return images;
    }
}
