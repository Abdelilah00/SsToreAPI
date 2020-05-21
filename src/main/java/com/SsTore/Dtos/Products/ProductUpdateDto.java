package com.SsTore.Dtos.Products;

import com.springBootLibrary.models.BaseDto;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProductUpdateDto extends BaseDto {
    @NotBlank
    private String name;

    @NotNull
    @Min(0)
    private Long qtyStock;
}
