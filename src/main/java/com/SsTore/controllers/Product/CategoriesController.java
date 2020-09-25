////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.Categories.CategoryCreateDto;
import com.SsTore.Dtos.Product.Categories.CategoryDto;
import com.SsTore.Dtos.Product.Categories.CategoryMenuDto;
import com.SsTore.Dtos.Product.Categories.CategoryUpdateDto;
import com.SsTore.domains.Product.Category;
import com.SsTore.services.Product.CategoryService;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/admin/categories")
public class CategoriesController extends BaseCrudController<Category, CategoryDto, CategoryCreateDto, CategoryUpdateDto> {

    @RequestMapping(path = "/getCategoryMenu", method = RequestMethod.GET)
    protected List<CategoryMenuDto> getCategoryMenu() throws ExecutionException, InterruptedException {
        return ((CategoryService) service).getCategoryMenu().get();
    }


}

