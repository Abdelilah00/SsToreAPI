////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers;

import com.SsTore.Dtos.Categories.CategoryCreateDto;
import com.SsTore.Dtos.Categories.CategoryDto;
import com.SsTore.Dtos.Categories.CategoryUpdateDto;
import com.SsTore.domains.Product.Category;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/categories")
public class CategoriesController extends BaseCrudController<Category, CategoryDto, CategoryCreateDto, CategoryUpdateDto> {

}

