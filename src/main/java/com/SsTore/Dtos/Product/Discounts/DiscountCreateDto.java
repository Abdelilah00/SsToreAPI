package com.SsTore.Dtos.Product.Discounts;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DiscountCreateDto extends BaseDto {
    private Float percent;
    private long productId;
    private Date endDate;
}
