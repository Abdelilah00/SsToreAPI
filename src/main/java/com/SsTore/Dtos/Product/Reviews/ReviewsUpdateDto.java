package com.SsTore.Dtos.Product.Reviews;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewsUpdateDto extends BaseDto {
    private Float stars;
    private String comment;
    //private Boolean helpful;
    private long productId;
}
