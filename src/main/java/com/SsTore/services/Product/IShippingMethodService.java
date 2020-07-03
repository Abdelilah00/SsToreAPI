////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.ShippingMethods.ShippingMethodCreateDto;
import com.SsTore.Dtos.Product.ShippingMethods.ShippingMethodDto;
import com.SsTore.Dtos.Product.ShippingMethods.ShippingMethodUpdateDto;
import com.SsTore.domains.Product.ShippingMethod;
import com.springBootLibrary.services.IBaseCrudService;

public interface IShippingMethodService extends IBaseCrudService<ShippingMethod, ShippingMethodDto, ShippingMethodCreateDto, ShippingMethodUpdateDto> {

}
