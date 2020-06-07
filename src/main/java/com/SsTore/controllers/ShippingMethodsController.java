////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers;

import com.SsTore.Dtos.ShippingMethods.ShippingMethodCreateDto;
import com.SsTore.Dtos.ShippingMethods.ShippingMethodDto;
import com.SsTore.Dtos.ShippingMethods.ShippingMethodUpdateDto;
import com.SsTore.domains.Product.ShippingMethod;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/shippingMethods")
public class ShippingMethodsController extends BaseCrudController<ShippingMethod, ShippingMethodDto, ShippingMethodCreateDto, ShippingMethodUpdateDto> {
}
