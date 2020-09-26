////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.Products.Image;
import com.SsTore.Dtos.Product.Products.ProductCreateDto;
import com.SsTore.Dtos.Product.Products.ProductDto;
import com.SsTore.Dtos.Product.Products.ProductUpdateDto;
import com.SsTore.domains.Product.Product;
import com.SsTore.services.Product.IProductService;
import com.SsTore.services.utils.Files.IFileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBootLibrary.controllers.BaseCrudController;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/admin/products")
public class ProductsController extends BaseCrudController<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {

    @Autowired
    IFileService iFileService;

    @PostMapping(path = "/withImages")
    public CompletableFuture<ProductDto> withImages(@RequestPart("images") @Valid @NotNull @NotBlank List<MultipartFile> images,
                                                    @RequestPart("product") @Valid String productInfo) throws IOException {
        for (var image : images)
            iFileService.saveMultipartFile(image);

        //resize for Cover image
        var image = images.get(0);
        iFileService.saveCoverMultipartFile(image);

        var objectMapper = new ObjectMapper();
        ProductCreateDto object = objectMapper.readValue(productInfo, ProductCreateDto.class);
        object.setImages(images.stream().map(MultipartFile::getOriginalFilename).collect(Collectors.toList()));

        return service.create(object);
    }

    @Override
    protected List<ProductDto> getAll() throws ExecutionException, InterruptedException {
        var tmp = super.getAll();
        tmp.forEach(prod -> {
            try {
                prod.setImageCover(iFileService.getFile("Cover/" + prod.getImages().get(0).getUrl()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return tmp;
    }

    @Override
    protected ProductDto getById(@PathVariable(value = "id") long id) throws InterruptedException, ExecutionException, IOException {
        var tmp = super.getById(id);
        var images = new ArrayList<Image>();

        tmp.setImageCover(iFileService.getFile("Cover/" + tmp.getImages().get(0).getUrl()));
        tmp.getImages().forEach(image -> {
            var x = new Image();
            try {
                x.setUrl(iFileService.getFile(image.getUrl()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            images.add(x);

        });

        tmp.setImages(images);
        return tmp;
    }
    //TODO:getByCategory-size(6-24)

    @GetMapping(path = "/getRelated/{id}")
    protected List<ProductDto> getRelated(@PathVariable(value = "id") Long id) throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getRelated(id).get();
        tmp.forEach(prod -> {
            try {
                prod.setImageCover(iFileService.getFile("Cover/" + prod.getImages().get(0).getUrl()));
                prod.setSale(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return tmp;
    }

    @GetMapping(path = "/getByCategory/{categoryId}")
    protected List<ProductDto> getByCategory(@PathVariable(value = "categoryId") Long categoryId) throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getByCategory(categoryId).get();
        tmp.forEach(prod -> {
            try {
                prod.setImageCover(iFileService.getFile("Cover/" + prod.getImages().get(0).getUrl()));
                prod.setSale(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return tmp;
    }

    @GetMapping(path = "/getBestSealed")
    protected List<ProductDto> getBestSealed() throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getBestSealed().get();
        tmp.forEach(prod -> {
            try {
                prod.setImageCover(iFileService.getFile("Cover/" + prod.getImages().get(0).getUrl()));
                prod.setSale(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return tmp;
    }

    @GetMapping(path = "/getNewest")
    protected List<ProductDto> getNewest() throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getNewest().get();
        tmp.forEach(prod -> {
            try {
                prod.setImageCover(iFileService.getFile("Cover/" + prod.getImages().get(0).getUrl()));
                prod.setNewest(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return tmp;
    }
}

