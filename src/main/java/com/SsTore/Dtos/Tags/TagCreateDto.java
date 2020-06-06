////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Tags;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagCreateDto extends BaseDto {
    private String name;
}