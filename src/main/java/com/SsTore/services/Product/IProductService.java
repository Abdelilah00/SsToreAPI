////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Products.ProductCreateDto;
import com.SsTore.Dtos.Product.Products.ProductDto;
import com.SsTore.Dtos.Product.Products.ProductUpdateDto;
import com.SsTore.domains.Product.Product;
import com.springBootLibrary.services.IBaseCrudService;

public interface IProductService extends IBaseCrudService<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {

}

