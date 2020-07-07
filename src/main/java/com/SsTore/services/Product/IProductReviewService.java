package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsCreateDto;
import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsDto;
import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsUpdateDto;
import com.SsTore.domains.Product.ProductReviews;
import com.springBootLibrary.services.IBaseCrudService;

public interface IProductReviewService extends IBaseCrudService<ProductReviews, ProductReviewsDto, ProductReviewsCreateDto, ProductReviewsUpdateDto> {

}
