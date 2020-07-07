package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsCreateDto;
import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsDto;
import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsUpdateDto;
import com.SsTore.domains.Product.ProductReviews;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/productReviews")
public class ProductReviewsController extends BaseCrudController<ProductReviews, ProductReviewsDto, ProductReviewsCreateDto, ProductReviewsUpdateDto> {

}
