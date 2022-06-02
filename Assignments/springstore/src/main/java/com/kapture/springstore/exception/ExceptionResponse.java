package com.kapture.springstore.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

public class ExceptionResponse {
    private final int status;
    private final String message;
    private final LocalDateTime createdAt;
    private final URI path;
    @JsonProperty("errors")
    private final List<Message> messages;

    private ExceptionResponse(HttpStatus httpStatus, LocalDateTime createdAt, URI path, List<Message> messages) {
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.createdAt = createdAt;
        this.path = path;
        this.messages = messages;
    }

    public static ExceptionResponse of(HttpStatus httpStatus, LocalDateTime createdAt, URI path, List<Message> messages) {
        return new ExceptionResponse(httpStatus, createdAt, path, messages);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public URI getPath() {
        return path;
    }

    public List<Message> getMessages() {
        return messages;
    }
}