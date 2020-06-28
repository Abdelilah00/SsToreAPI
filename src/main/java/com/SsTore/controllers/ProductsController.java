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
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/admin/products")
public class ProductsController extends BaseCrudController<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {

    @Autowired
    IFileService iFileService;

    @RequestMapping(method = RequestMethod.POST, path = "/withImages", consumes = {"multipart/form-data"})
    public CompletableFuture<ProductDto> withImages(@RequestPart("images") @Valid @NotNull @NotBlank List<MultipartFile> images,
                                                    @RequestPart("product") @Valid ProductCreateDto dto) {
        for (var image : images)
            iFileService.uploadFile(image);

        return service.create(dto);
    }


}

