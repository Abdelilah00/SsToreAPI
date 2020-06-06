////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.WareHouses.WareHouseCreateDto;
import com.SsTore.Dtos.WareHouses.WareHouseDto;
import com.SsTore.Dtos.WareHouses.WareHouseUpdateDto;
import com.SsTore.domains.Product.ShippingMethod;
import com.springBootLibrary.services.IBaseCrudService;

public interface IShippingMethodService extends IBaseCrudService<ShippingMethod, WareHouseDto, WareHouseCreateDto, WareHouseUpdateDto> {

}
