package com.kapture.springbootmail.service;

import com.kapture.springbootmail.model.Mail;

public interface MailService {

    void sendSimpleMail(Mail mail);

    void sendHtmlMail(Mail mail);

    void sendAttachmentsMail(Mail mail);

    void sendInlineResourceMail(Mail mail);

}
