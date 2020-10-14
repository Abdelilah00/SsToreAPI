package com.SsTore.Dtos.Product.Products;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewsDto extends BaseDto {
    private Float stars;
    private String comment;
    //private Boolean helpful;
    private long productId;
}
