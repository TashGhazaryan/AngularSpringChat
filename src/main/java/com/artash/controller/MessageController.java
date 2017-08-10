package com.artash.controller;

import com.artash.data.dto.GetMessageDTO;
import com.artash.data.dto.MessageToDTOMapper;
import com.artash.data.dto.TestMessageDTO;
import com.artash.data.entity.Message;
import com.artash.data.entity.User;
import com.artash.service.MessageService;
import com.artash.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class MessageController {
    @Autowired
    private MyUserDetailsService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    MessageToDTOMapper mapper;



    public MessageController() {

    }

    @PostMapping("/message")
    public @ResponseBody
    ResponseEntity receiveMessage(@RequestBody GetMessageDTO msg) {
        User receiver = userService.findById(msg.getReceiverId());
        if (receiver != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String senderName = auth.getName();
            User sender = userService.findByUsername(senderName);
            Message message = new Message();
            message.setSender(sender);
            message.setDate(new Date());
            message.setReceiver(receiver);
            message.setMessage(msg.getMessage());
            messageService.save(message);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }


    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public List<TestMessageDTO> history(@RequestParam Long receiverId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String senderName = auth.getName();
        User sender = userService.findByUsername(senderName);

        List<Message> messages = messageService.testGetHistory(sender.getId(), receiverId);
        List<TestMessageDTO> messageDtos = new ArrayList<>();
        for (Message message : messages) {
            messageDtos.add(mapper.MessageToMessageDTO(message));
        }


        return messageDtos;
    }
}
