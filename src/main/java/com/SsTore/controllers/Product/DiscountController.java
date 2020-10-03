package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.Discounts.DiscountCreateDto;
import com.SsTore.Dtos.Product.Discounts.DiscountDto;
import com.SsTore.Dtos.Product.Discounts.DiscountUpdateDto;
import com.SsTore.domains.Product.Discount;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/discounts")
public class DiscountController extends BaseCrudController<Discount, DiscountDto, DiscountCreateDto, DiscountUpdateDto> {

}
