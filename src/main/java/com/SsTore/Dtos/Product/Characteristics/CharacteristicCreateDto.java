package com.SsTore.Dtos.Product.Characteristics;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CharacteristicCreateDto extends BaseDto {
    private String name;
    private List<String> values = new ArrayList<>();
}
