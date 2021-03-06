////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.Products.FilterDto;
import com.SsTore.Dtos.Product.Products.ProductCreateDto;
import com.SsTore.Dtos.Product.Products.ProductDto;
import com.SsTore.Dtos.Product.Products.ProductUpdateDto;
import com.SsTore.domains.Product.Product;
import com.SsTore.services.Product.IProductService;
import com.SsTore.services.utils.Files.IFileService;
import com.configuration.Exception.UserFriendlyException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springBootLibrary.controllers.BaseCrudController;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
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
                                                    @RequestPart("product") @Valid String productInfo) throws IOException, UserFriendlyException {
        //resize for Cover image
        //iFileService.saveCoverMultipartFile(images.get(0));

        var objectMapper = new ObjectMapper();
        ProductCreateDto tmp = objectMapper.readValue(productInfo, ProductCreateDto.class);

        tmp.setImages(images.stream().map(img -> {
            try {
                return iFileService.saveMultipartFile(img);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList()));

        return service.create(tmp);
    }

/*    @Override
    protected List<ProductDto> getAll() throws ExecutionException, InterruptedException {
        var tmp = super.getAll();
        tmp.forEach(prod -> {
            if (prod.getImages().size() > 0)
                prod.setImageCover(prod.getImages().get(0).getUrl());
        });
        return tmp;
    }

    //TODO: Get Characteristics and
    @Override
    protected ProductDto getById(@PathVariable(value = "id") long id) throws InterruptedException, ExecutionException, IOException {
        var tmp = super.getById(id);
        if (tmp.getImages().size() > 0)
            tmp.setImageCover(tmp.getImages().get(0).getUrl());
        return tmp;
    }*/

    //TODO:getByCategory-size(6-24)
    @GetMapping(path = "/getRelated/{id}")
    protected List<ProductDto> getRelated(@PathVariable(value = "id") Long id) throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getRelated(id).get();
       /* tmp.forEach(prod -> {
            if (prod.getImages().size() > 0)
                prod.setImageCover(prod.getImages().get(0).getUrl());
            //prod.setSale(true);
        });*/
        return tmp;
    }

    @GetMapping(path = "/getByCategory/{categoryId}")
    protected List<ProductDto> getByCategory(@PathVariable(value = "categoryId") Long categoryId) throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getByCategory(categoryId).get();
       /* tmp.forEach(prod -> {
            if (prod.getImages().size() > 0)
                prod.setImageCover(prod.getImages().get(0).getUrl());
            //prod.setSale(true);
        });*/
        return tmp;
    }

    @GetMapping(path = "/getBestSelling")
    protected List<ProductDto> getBestSelling() throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getBestSelling().get();
        /*tmp.forEach(prod -> {
            if (prod.getImages().size() > 0)
                prod.setImageCover(prod.getImages().get(0).getUrl());
            //prod.setSale(true);
        });*/
        return tmp;
    }

    @GetMapping(path = "/getNewest")
    protected List<ProductDto> getNewest() throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getNewest().get();
       /* tmp.forEach(prod -> {
            if (prod.getImages().size() > 0)
                prod.setImageCover(prod.getImages().get(0).getUrl());
        });*/
        return tmp;
    }

    /* @GetMapping(path = "/getNamesByQuery/{query}")
     protected List<String> getNamesByQuery(@PathVariable(value = "query") String query) throws ExecutionException, InterruptedException {
         return ((IProductService) service).getNamesByQuery(query).get();
     }
 */
    @GetMapping(path = "/getByQuery/{query}")
    protected List<ProductDto> getByQuery(@PathVariable(value = "query") String query) throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getByQuery(query).get();
      /*  tmp.forEach(prod -> {
            if (prod.getImages().size() > 0)
                prod.setImageCover(prod.getImages().get(0).getUrl());
            //prod.setSale(true);

        });*/
        return tmp;
    }

    @PostMapping(path = "/getByFilter")
    protected List<ProductDto> getByFilter(@RequestBody List<FilterDto> filterDto) throws ExecutionException, InterruptedException {
        var tmp = ((IProductService) service).getByFilter(filterDto).get();
        return tmp;
    }
}

