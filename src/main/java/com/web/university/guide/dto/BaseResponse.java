package com.web.university.guide.dto;

import java.util.ArrayList;
import java.util.List;

public  class BaseResponse<T> {

    private T body;
    private List<Message> messages = new ArrayList<>();

    public T getBody() {
        return body;
    }

    public BaseResponse<T> setBody(T body) {
        this.body = body;
        return this;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public BaseResponse<T> setMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

    public BaseResponse<T> addMessage(String code, String text, MessageType messageType) {
        this.messages.add(new Message().setCode(code).setText(text).setMessageType(messageType));
        return this;
    }

    public BaseResponse<T> addErrorMessage(String code, String text) {
        addMessage(code, text, MessageType.error);
        return this;
    }
}