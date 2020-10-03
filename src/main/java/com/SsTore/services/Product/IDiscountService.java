package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Discounts.DiscountCreateDto;
import com.SsTore.Dtos.Product.Discounts.DiscountDto;
import com.SsTore.Dtos.Product.Discounts.DiscountUpdateDto;
import com.SsTore.domains.Product.Discount;
import com.springBootLibrary.services.IBaseCrudService;

public interface IDiscountService extends IBaseCrudService<Discount, DiscountDto, DiscountCreateDto, DiscountUpdateDto> {

}
