package com.SsTore.Dtos.Product.Categories;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryMenuDto extends BaseDto {
    private String name;
    private List<CategoryMenuDto> children = new ArrayList<>();
}
