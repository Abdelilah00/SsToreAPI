package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsCreateDto;
import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsDto;
import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsUpdateDto;
import com.SsTore.domains.Product.ProductReviews;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewService extends BaseCrudServiceImpl<ProductReviews, ProductReviewsDto, ProductReviewsCreateDto, ProductReviewsUpdateDto> implements IProductReviewService {
    public ProductReviewService() {
        super(ProductReviews.class, ProductReviewsDto.class, ProductReviewsCreateDto.class, ProductReviewsUpdateDto.class);
    }
}
