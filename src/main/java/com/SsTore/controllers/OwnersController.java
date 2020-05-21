////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers;

import com.SsTore.Dtos.Owners.OwnerCreateDto;
import com.SsTore.Dtos.Owners.OwnerDto;
import com.SsTore.Dtos.Owners.OwnerUpdateDto;
import com.SsTore.services.IOwnerService;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/admin/owners")
public class OwnersController extends BaseCrudController<Owner, OwnerDto, OwnerCreateDto, OwnerUpdateDto> {
    @RequestMapping(method = RequestMethod.POST, path = "/withStore")
    public OwnerCreateDto withStore(@Valid @RequestBody OwnerCreateDto dto) {
        return ((IOwnerService) service).withStore(dto);
    }
}
