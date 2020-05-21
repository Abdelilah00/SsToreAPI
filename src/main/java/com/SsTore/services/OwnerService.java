////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.Owners.OwnerCreateDto;
import com.SsTore.Dtos.Owners.OwnerDto;
import com.SsTore.Dtos.Owners.OwnerUpdateDto;
import com.SsTore.domains.Owner;
import com.SsTore.domains.Store;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OwnerService extends BaseCrudServiceImpl<Owner, OwnerDto, OwnerCreateDto, OwnerUpdateDto> implements IOwnerService {
    public OwnerService() {
        super(Owner.class, OwnerDto.class, OwnerCreateDto.class, OwnerUpdateDto.class);
    }

    public OwnerCreateDto withStore(OwnerCreateDto dto) {
        var owner = objectMapper.convertToEntity(dto);
        owner.setTenantId(2L);
        var store = new Store();
        store.setTenantId(2L);
        store.setName(dto.getStoreName());
        store.setOwner(owner);
        owner.getStores().add(store);
        return objectMapper.convertToDto(repository.save(owner), OwnerCreateDto.class);
    }
}
