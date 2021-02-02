package com.web.university.guide.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class Message {

    private String code;

    private String text;

    private MessageType messageType;

    public Message(){

    }

    public Message(String text){
        this.text=text;
    }

    public String getCode() {
        return code;
    }

    public Message setCode(String code) {
        this.code = code;
        return this;
    }

    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public Message setMessageType(MessageType messageType) {
        this.messageType = messageType;
        return this;
    }

    @JsonIgnore
    public boolean isError() {
        return messageType.equals(MessageType.error);
    }


    public static Message getBadRequestMessage(String text) {
        return new Message().setCode(String.valueOf(HttpStatus.BAD_REQUEST.value())).setText(text).setMessageType(MessageType.error);
    }

    public static Message getNotFoundMessage(String text) {
        return new Message().setCode(String.valueOf(HttpStatus.NOT_FOUND.value())).setText(text).setMessageType(MessageType.error);
    }

    public static Message getSystemErrorMessage(String text) {
        return new Message().setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).setText(text).setMessageType(MessageType.error);
    }

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", text='" + text + '\'' +
                ", messageType=" + messageType +
                '}';
    }
}
