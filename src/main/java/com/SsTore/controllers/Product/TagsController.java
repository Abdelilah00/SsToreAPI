////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Product;

import com.SsTore.Dtos.Product.Tags.TagCreateDto;
import com.SsTore.Dtos.Product.Tags.TagDto;
import com.SsTore.Dtos.Product.Tags.TagUpdateDto;
import com.SsTore.domains.Product.Tag;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin/tags")
public class TagsController extends BaseCrudController<Tag, TagDto, TagCreateDto, TagUpdateDto> {
}
