package com.SsTore.Dtos.Owners;

import com.springBootLibrary.models.BaseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OwnerUpdateDto extends BaseDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String storeName;
}
