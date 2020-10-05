package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Reviews.ReviewsCreateDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsUpdateDto;
import com.SsTore.domains.Product.Reviews;
import com.SsTore.repositorys.Order.IOrderRepository;
import com.SsTore.repositorys.Product.IReviewsRepository;
import com.configuration.Exception.UserFriendlyException;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ReviewService extends BaseCrudServiceImpl<Reviews, ReviewsDto, ReviewsCreateDto, ReviewsUpdateDto> implements IReviewService {
    public ReviewService() {
        super(Reviews.class, ReviewsDto.class, ReviewsCreateDto.class, ReviewsUpdateDto.class);
    }

    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private IReviewsRepository iReviewsRepository;

    @Override
    public CompletableFuture<ReviewsDto> create(ReviewsCreateDto entity) throws UserFriendlyException {
        if (!iOrderRepository.isAlreadyOrdered(entity.getCustomerId(), entity.getProductId()))
            throw new UserFriendlyException("order this item first");
        if (iReviewsRepository.isAlreadyReviewed(entity.getCustomerId(), entity.getProductId()))
            throw new UserFriendlyException("you already reviewed this product");

        return super.create(entity);
    }
}
