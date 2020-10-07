package com.SsTore.Dtos.Account.Subscriptions;

import com.springBootLibrary.models.BaseDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class SubscriptionUpdateDto extends BaseDto {
    @Email
    private String email;
}
