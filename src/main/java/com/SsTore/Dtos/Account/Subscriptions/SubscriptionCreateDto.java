package com.SsTore.Dtos.Account.Subscriptions;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SubscriptionCreateDto extends BaseDto {
    @Email
    @NotEmpty
    @NotBlank
    @NotNull
    private String email;
}
