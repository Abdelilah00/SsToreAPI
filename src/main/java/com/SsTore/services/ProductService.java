////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.Products.ProductCreateDto;
import com.SsTore.Dtos.Products.ProductDto;
import com.SsTore.Dtos.Products.ProductUpdateDto;
import com.SsTore.domains.Product.Product;
import com.SsTore.repositorys.Product.*;
import com.configuration.TenantContext;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductService extends BaseCrudServiceImpl<Product, ProductDto, ProductCreateDto, ProductUpdateDto> implements IProductService {
    private static Logger logger = LoggerFactory.getLogger(TenantContext.class.getName());
    @Autowired
    private IImagesRepository imagesRepository;
    @Autowired
    private IOverviewRepository overviewRepository;
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
    public CompletableFuture<ProductDto> create(ProductCreateDto entity) {
        logger.info(entity.toString());
        return super.create(entity);
    }
}
