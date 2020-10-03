package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Discounts.DiscountCreateDto;
import com.SsTore.Dtos.Product.Discounts.DiscountDto;
import com.SsTore.Dtos.Product.Discounts.DiscountUpdateDto;
import com.SsTore.domains.Product.Discount;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DiscountService extends BaseCrudServiceImpl<Discount, DiscountDto, DiscountCreateDto, DiscountUpdateDto> implements IDiscountService {
    public DiscountService() {
        super(Discount.class, DiscountDto.class, DiscountCreateDto.class, DiscountUpdateDto.class);
    }
}
