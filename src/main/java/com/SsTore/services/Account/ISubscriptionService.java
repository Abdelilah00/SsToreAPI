////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Account;


import com.SsTore.domains.Account.Subscription;
import com.springBootLibrary.services.IBaseCrudService;
import com.SsTore.Dtos.Account.Subscriptions.SubscriptionDto;
import com.SsTore.Dtos.Account.Subscriptions.SubscriptionCreateDto;
import com.SsTore.Dtos.Account.Subscriptions.SubscriptionUpdateDto;

public interface ISubscriptionService extends IBaseCrudService<Subscription, SubscriptionDto, SubscriptionCreateDto, SubscriptionUpdateDto> {

}
