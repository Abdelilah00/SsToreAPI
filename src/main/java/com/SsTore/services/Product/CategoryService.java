////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Categories.CategoryCreateDto;
import com.SsTore.Dtos.Product.Categories.CategoryDto;
import com.SsTore.Dtos.Product.Categories.CategoryMenuDto;
import com.SsTore.Dtos.Product.Categories.CategoryUpdateDto;
import com.SsTore.domains.Product.Category;
import com.SsTore.repositorys.Product.ICategoryRepository;
import com.configuration.Exception.UserFriendlyException;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CategoryService extends BaseCrudServiceImpl<Category, CategoryDto, CategoryCreateDto, CategoryUpdateDto> implements ICategoryService {
    public CategoryService() {
        super(Category.class, CategoryDto.class, CategoryCreateDto.class, CategoryUpdateDto.class);
    }

    public CompletableFuture<List<CategoryMenuDto>> getTree() {
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(((ICategoryRepository) repository).findByParentIdIsNull(), CategoryMenuDto.class));
    }

    @Override
    public CompletableFuture<List<CategoryDto>> getParents() {
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(((ICategoryRepository) repository).findByParentIdIsNull(), CategoryDto.class));
    }

    @Override
    public CompletableFuture<List<CategoryDto>> getChildren(Long parentId) {
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(((ICategoryRepository) repository).findByParentId(parentId), CategoryDto.class));
    }

    @Override
    public CompletableFuture<CategoryDto> create(CategoryCreateDto entity) throws UserFriendlyException {
        var tmp = objectMapper.convertToEntity(entity);
        try {
            var cat = new Category();
            cat.setId(entity.getParentId());
            tmp.setParent(cat);
        } catch (Exception ex) {

        }


        return CompletableFuture.completedFuture(objectMapper.convertToDto(repository.save(tmp), CategoryDto.class));
    }
}

