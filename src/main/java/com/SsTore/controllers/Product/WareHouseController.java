////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Product;


import com.SsTore.Dtos.Product.WareHouses.WareHouseCreateDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseDto;
import com.SsTore.Dtos.Product.WareHouses.WareHouseUpdateDto;
import com.SsTore.domains.Product.WareHouse;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/wareHouses")
public class WareHouseController extends BaseCrudController<WareHouse, WareHouseDto, WareHouseCreateDto, WareHouseUpdateDto> {
}
