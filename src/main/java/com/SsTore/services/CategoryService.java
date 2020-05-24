////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.Categories.CategoryCreateDto;
import com.SsTore.Dtos.Categories.CategoryDto;
import com.SsTore.Dtos.Categories.CategoryUpdateDto;
import com.SsTore.domains.Product.Category;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseCrudServiceImpl<Category, CategoryDto, CategoryCreateDto, CategoryUpdateDto> implements ICategoryService {
    public CategoryService() {
        super(Category.class, CategoryDto.class, CategoryCreateDto.class, CategoryUpdateDto.class);
    }

}
