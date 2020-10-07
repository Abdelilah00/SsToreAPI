////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.services.Account;


import com.SsTore.Dtos.Account.Subscriptions.SubscriptionCreateDto;
import com.SsTore.Dtos.Account.Subscriptions.SubscriptionDto;
import com.SsTore.Dtos.Account.Subscriptions.SubscriptionUpdateDto;
import com.SsTore.domains.Account.Subscription;
import com.SsTore.repositorys.Account.ISubscriptionRepository;
import com.configuration.Exception.UserFriendlyException;
import com.springBootLibrary.services.BaseCrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class SubscriptionService extends BaseCrudServiceImpl<Subscription, SubscriptionDto, SubscriptionCreateDto, SubscriptionUpdateDto> implements ISubscriptionService {

    public SubscriptionService() {
        super(Subscription.class, SubscriptionDto.class, SubscriptionCreateDto.class, SubscriptionUpdateDto.class);
    }

    @Override
    public CompletableFuture<SubscriptionDto> create(SubscriptionCreateDto entity) throws UserFriendlyException {
        //already subs
        if (((ISubscriptionRepository) repository).existsByEmail(entity.getEmail()))
            throw new UserFriendlyException("You Already Subscribed");
        return super.create(entity);
    }
}

