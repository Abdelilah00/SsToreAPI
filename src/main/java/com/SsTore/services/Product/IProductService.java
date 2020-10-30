////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Characteristics.CharacteristicCreateDto;
import com.SsTore.Dtos.Product.Characteristics.CharacteristicDto;
import com.SsTore.Dtos.Product.Products.FilterDto;
import com.SsTore.Dtos.Product.Products.ProductCreateDto;
import com.SsTore.Dtos.Product.Products.ProductDto;
import com.SsTore.Dtos.Product.Products.ProductUpdateDto;
import com.SsTore.domains.Product.Characteristic;
import com.SsTore.domains.Product.Product;
import com.springBootLibrary.services.IBaseCrudService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IProductService extends IBaseCrudService<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {
    CompletableFuture<List<ProductDto>> getRelated(Long id);

    CompletableFuture<List<ProductDto>> getByCategory(Long categoryId);

    CompletableFuture<List<ProductDto>> getByQuery(String query);

    CompletableFuture<List<ProductDto>> getByFilter(List<FilterDto> filter);

    //CompletableFuture<List<String>> getNamesByQuery(String query);

    CompletableFuture<List<ProductDto>> getBestSelling();

    CompletableFuture<List<ProductDto>> getNewest();
}

