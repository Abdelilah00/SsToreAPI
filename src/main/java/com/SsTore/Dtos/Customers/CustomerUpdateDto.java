package com.SsTore.Dtos.Customers;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CustomerUpdateDto extends BaseDto {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;
}
