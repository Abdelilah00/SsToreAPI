////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services;

import com.SsTore.Dtos.ShippingMethods.ShippingMethodCreateDto;
import com.SsTore.Dtos.ShippingMethods.ShippingMethodDto;
import com.SsTore.Dtos.ShippingMethods.ShippingMethodUpdateDto;
import com.SsTore.domains.Product.ShippingMethod;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShippingMethodService extends BaseCrudServiceImpl<ShippingMethod, ShippingMethodDto, ShippingMethodCreateDto, ShippingMethodUpdateDto> implements IShippingMethodService {
    public ShippingMethodService() {
        super(ShippingMethod.class, ShippingMethodDto.class, ShippingMethodCreateDto.class, ShippingMethodUpdateDto.class);
    }

}
