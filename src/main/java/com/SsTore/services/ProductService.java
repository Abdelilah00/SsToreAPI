////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.Products.ProductCreateDto;
import com.SsTore.Dtos.Products.ProductDto;
import com.SsTore.Dtos.Products.ProductUpdateDto;
import com.SsTore.domains.Product.*;
import com.SsTore.repositorys.Product.IProductRepository;
import com.configuration.TenantContext;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ProductService extends BaseCrudServiceImpl<Product, ProductDto, ProductCreateDto, ProductUpdateDto> implements IProductService {
    private static Logger logger = LoggerFactory.getLogger(TenantContext.class.getName());
    @Autowired
    private IProductRepository productRepository;

    public ProductService() {
        super(Product.class, ProductDto.class, ProductCreateDto.class, ProductUpdateDto.class);
    }

    @Override
    public CompletableFuture<ProductDto> create(ProductCreateDto productCreateDto) {

        var product = objectMapper.convertToEntity(productCreateDto);

        product.setProductCategories(productCreateDto.getCategoriesId().stream().map(catId -> {
            var productCategories = new ProductCategories();
            productCategories.getCategory().setId(catId);
            productCategories.setProduct(product);
            return productCategories;
        }).collect(Collectors.toList()));

        product.setProductTags(productCreateDto.getTagsId().stream().map(tagId -> {
            var productTags = new ProductTags();
            productTags.getTag().setId(tagId);
            productTags.setProduct(product);
            return productTags;
        }).collect(Collectors.toList()));

        product.setProductInList(productCreateDto.getWareHouseId().stream().map(wHouseId -> {
            var productIn = new ProductIn();
            productIn.getWareHouse().setId(wHouseId);
            productIn.setProduct(product);
            return productIn;
        }).collect(Collectors.toList()));

        product.setProductShippedByList(productCreateDto.getShippingMethodsId().stream().map(shipId -> {
            var productShippedBy = new ProductShippedBy();
            productShippedBy.getShippingMethod().setId(shipId);
            productShippedBy.setProduct(product);
            return productShippedBy;
        }).collect(Collectors.toList()));

        product.setImages(productCreateDto.getImages().stream().map(img -> {
            var image = new Image();
            image.setUrl(img.getOriginalFilename());
            image.setProduct(product);
            return image;
        }).collect(Collectors.toList()));


        //TODO: stream also each value
/*
        product.setProductCharacteristics();
*/

        productRepository.save(product);
        return CompletableFuture.completedFuture(objectMapper.convertToDto(product, ProductDto.class));
    }

 /*   private void UpdateProductCategories(long productId, ArrayList<Category> categories) {

    }

    private void UpdateProductTags(long tagId, ArrayList<Tag> tags) {

    }

    private void UpdateProductWareHouses(long wareHouseId, ArrayList<WareHouse> wareHouses) {

    }*/
}
