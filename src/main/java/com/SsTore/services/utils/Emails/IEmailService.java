package com.SsTore.services.utils.Emails;

import javax.mail.MessagingException;
import java.io.IOException;

public interface IEmailService {
    void sendSubscriptionWelcomeEmail(String to) throws MessagingException, IOException;

    void sendAccountWelcomeEmail(String to) throws MessagingException, IOException;

    void sendOrderEmail(String to) throws MessagingException, IOException;

    void sendWishListEmail(String to) throws MessagingException, IOException;

    void sendNewestEmail(String to) throws MessagingException, IOException;
}
