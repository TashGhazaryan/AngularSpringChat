package com.artash.service;

import com.artash.data.entity.Message;
import com.artash.data.entity.User;
import com.artash.data.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void addMessage(Message message) {
        messageRepository.save(message);
    }

    public void save(Message message) {
        messageRepository.save(message);
    }

    public List<Message> getHistory(User sender, User receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }

    public List<Message> testGetHistory(Long sender, Long receiver) {
        return messageRepository.testFind(sender, receiver);
    }
}
