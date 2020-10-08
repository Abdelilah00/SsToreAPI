////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2020                                                          /
// developed by Abdelilah Dehaoui GitHub : Abdelilah00                         /
////////////////////////////////////////////////////////////////////////////////

package com.SsTore.controllers.Account;


import com.SsTore.Dtos.Account.Subscriptions.SubscriptionCreateDto;
import com.SsTore.Dtos.Account.Subscriptions.SubscriptionDto;
import com.SsTore.Dtos.Account.Subscriptions.SubscriptionUpdateDto;
import com.SsTore.domains.Account.Subscription;
import com.SsTore.services.utils.Emails.IEmailService;
import com.configuration.Exception.UserFriendlyException;
import com.springBootLibrary.controllers.BaseCrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/admin/subscriptions")
public class SubscriptionsController extends BaseCrudController<Subscription, SubscriptionDto, SubscriptionCreateDto, SubscriptionUpdateDto> {

    @Autowired
    IEmailService iEmailService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    protected SubscriptionDto create(@Valid @RequestBody SubscriptionCreateDto dto) throws ExecutionException, InterruptedException, UserFriendlyException, IOException, MessagingException {
        var tmp = super.create(dto);
        CompletableFuture.runAsync(() -> {
            try {
                iEmailService.sendSubscriptionWelcomeEmail(tmp.getEmail());
            } catch (MessagingException | IOException e) {
                e.printStackTrace();
            }
        });
        return tmp;
    }
}
