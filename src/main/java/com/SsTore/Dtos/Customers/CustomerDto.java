////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.Dtos.Customers;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CustomerDto extends BaseDto {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;
}
