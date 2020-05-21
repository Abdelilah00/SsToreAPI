////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.Owners.OwnerCreateDto;
import com.SsTore.Dtos.Owners.OwnerDto;
import com.SsTore.Dtos.Owners.OwnerUpdateDto;
import com.SsTore.domains.Owner;
import com.springBootLibrary.services.IBaseCrudService;

public interface IOwnerService extends IBaseCrudService<Owner, OwnerDto, OwnerCreateDto, OwnerUpdateDto> {
    OwnerCreateDto withStore(OwnerCreateDto dto);
}
