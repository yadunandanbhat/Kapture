package com.kapture.springbootmail.service;

import com.kapture.springbootmail.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendSimpleMail(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        // This helper also has a method to set sent date
        message.setFrom(from);
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getBody());

        try {
            mailSender.send(message);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void sendHtmlMail(Mail mail) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);
            
            mailSender.send(message);
        } catch (MessagingException e) {
            System.out.println(e);
        }
    }

    @Override
    public void sendAttachmentsMail(Mail mail) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), true);

            FileSystemResource file = new FileSystemResource(new File(mail.getAttachment()));
            String fileName = mail.getAttachment().substring(mail.getAttachment().lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            mailSender.send(message);
        } catch (MessagingException e) {
            System.out.println(e);
        }
    }

    public void sendInlineResourceMail (Mail mail) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getBody(), false);
            FileSystemResource res = new FileSystemResource(new File(mail.getAttachment()));
            // I can also use ClassPathResource for this and use a upload button to upload files to the resources folder
            // And then use ClassPathResource to send inline
            helper.addInline("someName", res);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /*
     TODO Add a method to send with CC/BCC and with optional parameters like Reply/Reply to all etc,
      as the MimeMessageHelper has those methods
    */

}
