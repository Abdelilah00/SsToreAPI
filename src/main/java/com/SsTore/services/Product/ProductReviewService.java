package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsCreateDto;
import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsDto;
import com.SsTore.Dtos.Product.ProductReviews.ProductReviewsUpdateDto;
import com.SsTore.domains.Product.Reviews;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewService extends BaseCrudServiceImpl<Reviews, ProductReviewsDto, ProductReviewsCreateDto, ProductReviewsUpdateDto> implements IProductReviewService {
    public ProductReviewService() {
        super(Reviews.class, ProductReviewsDto.class, ProductReviewsCreateDto.class, ProductReviewsUpdateDto.class);
    }
}
