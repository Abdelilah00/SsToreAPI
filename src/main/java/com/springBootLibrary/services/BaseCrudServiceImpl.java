////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.springBootLibrary.services;

import com.springBootLibrary.models.BaseDto;
import com.springBootLibrary.models.BaseEntity;
import com.springBootLibrary.repositorys.IBaseJpaRepository;
import com.springBootLibrary.utilis.ModelEntityMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Transactional
public class BaseCrudServiceImpl<TEntity extends BaseEntity,
        TDto extends BaseDto,
        TCreateDto extends BaseDto,
        TUpdateDto extends BaseDto>
        implements IBaseCrudService<TEntity, TDto, TCreateDto, TUpdateDto> {

    @Autowired
    protected IBaseJpaRepository<TEntity> repository;
    protected ModelEntityMapping<TEntity> objectMapper = new ModelEntityMapping<>();
    private Class<TDto> dtoClass;
    private Class<TCreateDto> dtoCreateClass;
    private Class<TUpdateDto> dtoUpdateClass;

    public BaseCrudServiceImpl(Class<TEntity> tEntityClass, Class<TDto> dtoClass, Class<TCreateDto> dtoCreateClass, Class<TUpdateDto> dtoUpdateClass) {
        objectMapper.setEntityClass(tEntityClass);
        this.dtoClass = dtoClass;
        this.dtoCreateClass = dtoCreateClass;
        this.dtoUpdateClass = dtoUpdateClass;
    }

    @Override
    public CompletableFuture<List<TDto>> findAll() {
        return CompletableFuture.completedFuture(objectMapper.convertToDtoList(repository.findAll(), dtoClass));
    }

    @Override
    public TDto getOne(Long aLong) {
        return null;
    }

    @Override
    public Page<TDto> findAll(Pageable pageable) {
        return (null);
    }

    @Override
    public CompletableFuture<TDto> create(TCreateDto entity) {
        return CompletableFuture.completedFuture(objectMapper.convertToDto(repository.save(objectMapper.convertToEntity(entity)), dtoCreateClass));
    }

    @Override
    public CompletableFuture<TDto> update(TUpdateDto entity) {
        return CompletableFuture.completedFuture(objectMapper.convertToDto(repository.save(objectMapper.convertToEntity(entity)), dtoUpdateClass));
    }

    @Override
    public CompletableFuture<TDto> findById(Long aLong) {
        return CompletableFuture.completedFuture(objectMapper.convertToDto(repository.findById(aLong).get(), dtoClass));
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<TDto> findAll(Sort sort) {
        return (null);
    }

    @Override
    public List<TDto> saveAll(Iterable<TDto> entities) {
        return (null);
    }

    @Override
    public TDto saveAndFlush(TDto entity) {
        return (null);
    }

    @Override
    public void deleteInBatch(Iterable<TDto> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public List<TDto> findAll(Example<TDto> example) {
        return (null);
    }

    @Override
    public List<TDto> findAll(Example<TDto> example, Sort sort) {
        return (null);
    }


    @Override
    public void delete(TDto entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends TDto> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Optional<TDto> findOne(Example<TDto> example) {
        return null;
    }

    @Override
    public Page<TDto> findAll(Example<TDto> example, Pageable pageable) {
        return (null);
    }
}
