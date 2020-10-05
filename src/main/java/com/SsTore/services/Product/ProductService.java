////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Products.ProductCreateDto;
import com.SsTore.Dtos.Product.Products.ProductDto;
import com.SsTore.Dtos.Product.Products.ProductUpdateDto;
import com.SsTore.domains.Product.*;
import com.SsTore.repositorys.Product.ICategoryRepository;
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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ProductService extends BaseCrudServiceImpl<Product, ProductDto, ProductCreateDto, ProductUpdateDto> implements IProductService {
    private static final Logger logger = LoggerFactory.getLogger(TenantContext.class.getName());
    private final Pageable pageable = PageRequest.of(0, 8, Sort.by("createdAt").descending());
    private final Pageable pageableBestSelling = PageRequest.of(0, 8);

    @Autowired
    private IProductRepository iProductRepository;
    @Autowired
    private ICategoryRepository iCategoryRepository;


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

        product.setProductShippedBy(productCreateDto.getShippingMethodsId().stream().map(shipId -> {
            var productShippedBy = new ProductShippedBy();
            productShippedBy.getShippingMethod().setId(shipId);
            productShippedBy.setProduct(product);
            return productShippedBy;
        }).collect(Collectors.toList()));

        var images = productCreateDto.getImages().stream().map(img -> {
            var image = new Image();
            image.setName(img);
            image.setProduct(product);
            return image;
        }).collect(Collectors.toList());
        images.get(0).setCover(true);
        product.setImages(images);

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
            var productCharacteristic = new ProductCharacteristic();
            productCharacteristic.setValue(c.getValues());
            productCharacteristic.setCharacteristic(ch);
            productCharacteristic.setProduct(product);
            productCharacteristics.add(productCharacteristic);
        }
        product.setProductCharacteristics(productCharacteristics);

        //Update newest list
        var list = iProductRepository.findAll(pageable).toList();
        if (list.size() > 7) {
            var firstNewest = list.get(7);
            firstNewest.setNewest(false);
            iProductRepository.save(firstNewest);
        }

        //save Product
        iProductRepository.save(product);

        return CompletableFuture.completedFuture(objectMapper.convertToDto(product, ProductDto.class));
    }

    //TODO: By tags
    //TODO: Make sure Parent Categories didnt have products
    public CompletableFuture<List<ProductDto>> getRelated(Long id) {
        var category = iCategoryRepository.findByProductId(id).get(0);
        List<Product> products = iProductRepository.findByCategoryParentId(category.getParent().getId());
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(products, ProductDto.class));
    }

    public CompletableFuture<List<ProductDto>> getByCategory(Long categoryId) {
        var category = iCategoryRepository.findById(categoryId).get();
        List<Product> products = category.getParent() == null ? iProductRepository.findByCategoryParentId(category.getId()) : iProductRepository.findByCategoryId(category.getId());


        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(products, ProductDto.class));
    }

    //search by sub string
    public CompletableFuture<List<ProductDto>> getByQuery(String query) {
        List<String> querys = Arrays.asList(query.split("\\s+"));
        List<Product> result = new ArrayList<>();

        querys.forEach(str -> {
            var tmp = iProductRepository.findByNameContains(str);
            result.addAll(tmp);
        });

        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(result, ProductDto.class));
    }

    /*public CompletableFuture<List<String>> getNamesByQuery(String query) {
        var tmp = iProductRepository.findNameByNameContains(query);
        var list = tmp.stream().map(Product::getName).collect(Collectors.toList());
        return CompletableFuture.completedFuture(list);
    }*/

    public CompletableFuture<List<ProductDto>> getNewest() {
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(iProductRepository.findByNewestIsTrueOrderByCreatedAtDesc(), ProductDto.class));
    }


    public CompletableFuture<List<ProductDto>> getBestSelling() {
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(iProductRepository.findBestSelling(pageableBestSelling), ProductDto.class));
    }
}
