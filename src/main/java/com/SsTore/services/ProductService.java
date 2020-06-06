////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.Products.ProductCreateDto;
import com.SsTore.Dtos.Products.ProductDto;
import com.SsTore.Dtos.Products.ProductUpdateDto;
import com.SsTore.domains.Product.*;
import com.SsTore.repositorys.Product.*;
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
    @Autowired
    private IImagesRepository imagesRepository;

    @Autowired
    private ISpecificationRepository specificationRepository;
    @Autowired
    private ITagRepository tagRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private ICharacteristicRepository characteristicRepository;
    @Autowired
    private IWareHouseRepository wareHouseRepository;


    public ProductService() {
        super(Product.class, ProductDto.class, ProductCreateDto.class, ProductUpdateDto.class);
    }

    @Override
    public CompletableFuture<ProductDto> create(ProductCreateDto productCreateDto) {
        //TODO : Create new Category and link it or link it only if already exist
        //TODO : Create new WareHouse and link it or link it only if already exist
        //TODO : Create new Tag and link it or link it only if already exist

        var product = objectMapper.convertToEntity(productCreateDto);


        product.setProductCategories(productCreateDto.getCategoriesName().stream()
                .map(catName -> new ProductCategories(product, new Category(catName))).collect(Collectors.toList()));
        product.setProductTags(productCreateDto.getTagsName().stream()
                .map(name -> new ProductTags(product, new Tag(name))).collect(Collectors.toList()));
        product.setProductInList(productCreateDto.getWareHouseCountry().stream()
                .map(country -> new ProductIn(product, new WareHouse(country))).collect(Collectors.toList()));
        product.setProductShippedByList(productCreateDto.getShippingMethodsName().stream()
                .map(name -> new ProductShippedBy(product, new ShippingMethod(name))).collect(Collectors.toList()));

        //TODO: stream also each value
/*
        product.setProductCharacteristics();
*/

        product.setImages(productCreateDto.getImages().stream().map(Image::new).collect(Collectors.toList()));
        productRepository.save(product);

        return CompletableFuture.completedFuture(objectMapper.convertToDto(product, ProductDto.class));
    }
}
