package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.Reviews.ReviewsCreateDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsDto;
import com.SsTore.Dtos.Product.Reviews.ReviewsUpdateDto;
import com.SsTore.domains.Product.Reviews;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/admin/reviews")
public class ReviewController extends BaseCrudController<Reviews, ReviewsDto, ReviewsCreateDto, ReviewsUpdateDto> {

}
