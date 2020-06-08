////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers;

import com.SsTore.Dtos.Products.ProductCreateDto;
import com.SsTore.Dtos.Products.ProductDto;
import com.SsTore.Dtos.Products.ProductUpdateDto;
import com.SsTore.domains.Product.Product;
import com.SsTore.services.IFileService;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/admin/products")
public class ProductsController extends BaseCrudController<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {
    @Autowired
    private IFileService iFileService;

    @PostMapping("/createWithImages")
    public ProductDto createWithImages(@Valid @ModelAttribute ProductCreateDto productCreateDto) throws ExecutionException, InterruptedException {
        for (var img : productCreateDto.getImages()) {
            iFileService.UploadFile(img);
        }

        return super.create(productCreateDto);
    }
}

