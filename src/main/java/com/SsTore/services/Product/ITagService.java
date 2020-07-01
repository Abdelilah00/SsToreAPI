////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Tags.TagCreateDto;
import com.SsTore.Dtos.Product.Tags.TagDto;
import com.SsTore.Dtos.Product.Tags.TagUpdateDto;
import com.SsTore.domains.Product.Tag;
import com.springBootLibrary.services.IBaseCrudService;

public interface ITagService extends IBaseCrudService<Tag, TagDto, TagCreateDto, TagUpdateDto> {

}
