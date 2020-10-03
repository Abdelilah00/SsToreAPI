package com.SsTore.Dtos.Product.Discounts;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DiscountDto extends BaseDto {
    private Float percent = 0F;
    private Date endDate = new Date();
}

