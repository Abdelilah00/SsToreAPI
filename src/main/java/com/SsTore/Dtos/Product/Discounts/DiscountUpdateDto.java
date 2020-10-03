package com.SsTore.Dtos.Product.Discounts;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountUpdateDto extends BaseDto {
    private Float percent;
    private long ProductId;
}
