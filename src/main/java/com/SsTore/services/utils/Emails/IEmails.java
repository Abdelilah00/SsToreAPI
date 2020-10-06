package com.SsTore.services.utils.Emails;

import javax.mail.MessagingException;
import java.io.IOException;

public interface IEmails {
    void sendEmail(String to) throws MessagingException, IOException;
}
