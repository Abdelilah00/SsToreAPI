////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.WareHouses.WareHouseCreateDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseUpdateDto;
import com.SsTore.domains.Product.WareHouse;
import com.springBootLibrary.services.IBaseCrudService;

public interface IWareHouseService extends IBaseCrudService<WareHouse, WareHouseDto, WareHouseCreateDto, WareHouseUpdateDto> {

}
