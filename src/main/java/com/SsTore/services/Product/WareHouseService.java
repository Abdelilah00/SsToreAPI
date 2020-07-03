////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.WareHouses.WareHouseCreateDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseUpdateDto;
import com.SsTore.domains.Product.WareHouse;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WareHouseService extends BaseCrudServiceImpl<WareHouse, WareHouseDto, WareHouseCreateDto, WareHouseUpdateDto> implements IWareHouseService {
    public WareHouseService() {
        super(WareHouse.class, WareHouseDto.class, WareHouseCreateDto.class, WareHouseUpdateDto.class);
    }

}
