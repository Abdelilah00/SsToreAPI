////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Product;

import com.SsTore.Dtos.Product.Tags.TagCreateDto;
import com.SsTore.Dtos.Product.Tags.TagDto;
import com.SsTore.Dtos.Product.Tags.TagUpdateDto;
import com.SsTore.domains.Product.Tag;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TagService extends BaseCrudServiceImpl<Tag, TagDto, TagCreateDto, TagUpdateDto> implements ITagService {
    public TagService() {
        super(Tag.class, TagDto.class, TagCreateDto.class, TagUpdateDto.class);
    }

}
