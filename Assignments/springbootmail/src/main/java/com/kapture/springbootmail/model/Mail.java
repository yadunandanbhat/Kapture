package com.kapture.springbootmail.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class Mail {
    @NotBlank(message = "Recipient should not be blank!")
    private String to;
    private String body;
    @NotBlank(message = "Subject should not be blank!")
    private String subject;
    private String attachment;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
