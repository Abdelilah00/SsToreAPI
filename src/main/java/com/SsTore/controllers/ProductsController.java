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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBootLibrary.controllers.BaseCrudController;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/admin/products")
public class ProductsController extends BaseCrudController<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {

    @Autowired
    IFileService iFileService;

    @PostMapping(path = "/withImages")
    public CompletableFuture<ProductDto> withImages(@RequestPart("images") @Valid @NotNull @NotBlank List<MultipartFile> images,
                                                    @RequestPart("product") @Valid String productInfo) throws JsonProcessingException {
        for (var image : images)
            iFileService.uploadFile(image);

        var objectMapper = new ObjectMapper();
        ProductCreateDto object = objectMapper.readValue(productInfo, ProductCreateDto.class);
        object.setImages(images.stream().map(MultipartFile::getOriginalFilename).collect(Collectors.toList()));

        return service.create(object);
    }


}

