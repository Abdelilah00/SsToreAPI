////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.ShippingMethods.ShippingMethodCreateDto;
import com.SsTore.Dtos.Product.ShippedBy.ShippedByDto;
import com.SsTore.Dtos.Product.ShippingMethods.ShippingMethodDto;
import com.SsTore.Dtos.Product.ShippingMethods.ShippingMethodUpdateDto;
import com.SsTore.domains.Product.ShippingMethod;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShippingMethodService extends BaseCrudServiceImpl<ShippingMethod, ShippingMethodDto, ShippingMethodCreateDto, ShippingMethodUpdateDto> implements IShippingMethodService {
    public ShippingMethodService() {
        super(ShippingMethod.class, ShippingMethodDto.class, ShippingMethodCreateDto.class, ShippingMethodUpdateDto.class);
    }

}
