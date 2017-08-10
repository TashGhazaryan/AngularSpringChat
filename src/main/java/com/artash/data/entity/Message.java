package com.artash.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message implements Comparable<Message>  {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User sender;

    @ManyToOne(cascade = CascadeType.ALL)
    private User receiver;

    @Column
    private String message;

    @Column
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public int compareTo(Message message) {
        return getDate().compareTo(message.getDate());
    }

//    public TestMessageDTO convertToDTO() {
//        TestMessageDTO messageDto = new TestMessageDTO();
//        messageDto.setMessage(this.message);
//        messageDto.setReceiverId(this.receiver.getId());
//        messageDto.setSenderId(this.sender.getId());
//        return messageDto;
//    }


}
