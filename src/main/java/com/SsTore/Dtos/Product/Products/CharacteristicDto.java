package com.SsTore.Dtos.Product.Products;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacteristicDto extends BaseDto {
    private List<String> values;
    private String characteristicName;
}
