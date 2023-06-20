package com.group7.be.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.group7.be.enumerate.MessageType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message{
    private String sender;
    private String username;
    private String content;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;
    private MessageType type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}
