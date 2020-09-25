////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Products.ProductCreateDto;
import com.SsTore.Dtos.Product.Products.ProductDto;
import com.SsTore.Dtos.Product.Products.ProductUpdateDto;
import com.SsTore.domains.Product.*;
import com.SsTore.repositorys.Product.IProductRepository;
import com.configuration.TenantContext;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ProductService extends BaseCrudServiceImpl<Product, ProductDto, ProductCreateDto, ProductUpdateDto> implements IProductService {
    private static final Logger logger = LoggerFactory.getLogger(TenantContext.class.getName());
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

        product.setProductInList(productCreateDto.getWareHousesId().stream().map(wHouseId -> {
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
            image.setUrl(img);
            image.setProduct(product);
            return image;
        }).collect(Collectors.toList()));


        product.setSpecifications(productCreateDto.getSpecifications().stream().map(spc -> {
            var specification = new Specification();
            specification.setName(spc.getName());
            specification.setValue(spc.getValue());
            specification.setProduct(product);
            return specification;
        }).collect(Collectors.toList()));

        //TODO: stream also each value
        var productCharacteristics = new ArrayList<ProductCharacteristic>();
        for (var c : productCreateDto.getCharacteristics()) {
            var ch = new Characteristic();
            ch.setName(c.getName());
            for (var value : c.getValues()) {
                var productCharacteristic = new ProductCharacteristic();
                productCharacteristic.setValue(value);
                productCharacteristic.setCharacteristic(ch);
                productCharacteristic.setProduct(product);
                productCharacteristics.add(productCharacteristic);
            }
        }

        product.setProductCharacteristics(productCharacteristics);

        productRepository.save(product);
        return CompletableFuture.completedFuture(objectMapper.convertToDto(product, ProductDto.class));
    }

    public CompletableFuture<List<ProductDto>> getBestSealed() {
        Pageable pageable = PageRequest.of(0, 8, Sort.by("createdAt").ascending());
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(productRepository.findAll(pageable).toList(), ProductDto.class));
    }

    public CompletableFuture<List<ProductDto>> getNewest() {
        Pageable pageable = PageRequest.of(0, 8, Sort.by("createdAt").descending());
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(productRepository.findAll(pageable).toList(), ProductDto.class));
    }
}
