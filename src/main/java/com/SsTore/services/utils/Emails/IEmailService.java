package com.SsTore.services.utils.Emails;

import javax.mail.MessagingException;
import java.io.IOException;

public interface IEmailService {
    void sendWelcomeEmail(String to) throws MessagingException, IOException;
}
