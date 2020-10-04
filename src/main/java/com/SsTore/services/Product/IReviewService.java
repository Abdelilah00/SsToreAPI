package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Reviews.ReviewsCreateDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsUpdateDto;
import com.SsTore.domains.Product.Reviews;
import com.springBootLibrary.services.IBaseCrudService;

public interface IReviewService extends IBaseCrudService<Reviews, ReviewsDto, ReviewsCreateDto, ReviewsUpdateDto> {

}
