package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Reviews.ReviewsCreateDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsUpdateDto;
import com.SsTore.domains.Product.Reviews;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ReviewService extends BaseCrudServiceImpl<Reviews, ReviewsDto, ReviewsCreateDto, ReviewsUpdateDto> implements IReviewService {
    public ReviewService() {
        super(Reviews.class, ReviewsDto.class, ReviewsCreateDto.class, ReviewsUpdateDto.class);
    }

    @Override
    public CompletableFuture<ReviewsDto> create(ReviewsCreateDto entity) {
        return super.create(entity);
    }
}
