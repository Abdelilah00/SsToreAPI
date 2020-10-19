package com.SsTore.services.utils.Emails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailService implements IEmailService {
    @Value("${gmail.email}")
    private String email;
    @Value("${gmail.password}")
    private String password;


    public void sendSubscriptionWelcomeEmail(String to) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(email, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email Subject", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email From li Chwak sponsored by Google SMTP protocol", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        /*MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile("C:\\Users\\Alexis\\IdeaProjects\\SsToreAPI\\src\\main\\resources\\uploads\\images\\1601727606642_2020-09-07_010219.png");
        multipart.addBodyPart(attachPart);*/

        msg.setContent(multipart);
        Transport.send(msg);
    }

    public void sendAccountWelcomeEmail(String to) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(email, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email Subject", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email From li Chwak sponsored by Google SMTP protocol", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        /*MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile("C:\\Users\\Alexis\\IdeaProjects\\SsToreAPI\\src\\main\\resources\\uploads\\images\\1601727606642_2020-09-07_010219.png");
        multipart.addBodyPart(attachPart);*/

        msg.setContent(multipart);
        Transport.send(msg);
    }

    public void sendOrderEmail(String to) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(email, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject("Order Confirmation");
        msg.setContent("We Will Contact you to confirm your order as soon as possible", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("We Will Contact you to confirm your order as soon as possible SMTP protocol", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        /*MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile("C:\\Users\\Alexis\\IdeaProjects\\SsToreAPI\\src\\main\\resources\\uploads\\images\\1601727606642_2020-09-07_010219.png");
        multipart.addBodyPart(attachPart);*/

        msg.setContent(multipart);
        Transport.send(msg);
    }

    public void sendWishListEmail(String to) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(email, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email Subject", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email From li Chwak sponsored by Google SMTP protocol", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        /*MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile("C:\\Users\\Alexis\\IdeaProjects\\SsToreAPI\\src\\main\\resources\\uploads\\images\\1601727606642_2020-09-07_010219.png");
        multipart.addBodyPart(attachPart);*/

        msg.setContent(multipart);
        Transport.send(msg);
    }

    public void sendNewestEmail(String to) throws MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(email, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email Subject", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email From li Chwak sponsored by Google SMTP protocol", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        /*MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile("C:\\Users\\Alexis\\IdeaProjects\\SsToreAPI\\src\\main\\resources\\uploads\\images\\1601727606642_2020-09-07_010219.png");
        multipart.addBodyPart(attachPart);*/

        msg.setContent(multipart);
        Transport.send(msg);
    }
}
