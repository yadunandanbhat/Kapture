package com.kapture.springbootmail.controller;

import com.kapture.springbootmail.model.Mail;
import com.kapture.springbootmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    MailService ms;

    @PostMapping("/")
    public ResponseEntity sendMail(@RequestBody Mail mail, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception("Error in the body");
        }
        if (mail.getTo() != null && mail.getSubject() != null) {
            if (mail.getAttachment() != null) {
                ms.sendAttachmentsMail(mail);
            } else {
                ms.sendSimpleMail(mail);
            }
            return ResponseEntity.ok("Message sent successfully!");
        } else {
            return ResponseEntity.badRequest().body("Message not sent!");
        }
    }

    @PostMapping("/html")
    public ResponseEntity sendHtmlMail(@RequestBody Mail mail, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception("Error in the body");
        }
        if (mail.getTo()!=null && mail.getSubject()!=null) {
            if (mail.getAttachment() != null) {
                ms.sendAttachmentsMail(mail);
            } else {
                ms.sendHtmlMail(mail);
            }
            return ResponseEntity.ok("Message sent successfully!");
        } else {
            return ResponseEntity.badRequest().body("Message not sent!");
        }
    }

    @PostMapping("/inline")
    public ResponseEntity sendInlineMail(@RequestBody Mail mail, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception("Error!");
        }
        if (mail.getTo()!=null && mail.getSubject()!=null && mail.getBody()!=null && mail.getAttachment()!=null) {
            ms.sendInlineResourceMail(mail);
            return ResponseEntity.ok("Message sent successfully!");
        } else {
            return ResponseEntity.badRequest().body("Message not sent!");
        }
    }
}