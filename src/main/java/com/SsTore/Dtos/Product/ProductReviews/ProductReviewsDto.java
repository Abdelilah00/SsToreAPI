package com.SsTore.Dtos.Product.ProductReviews;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductReviewsDto extends BaseDto {
    private Long stars;
    private String review;
    private Boolean helpful;
    private long productId;
}
