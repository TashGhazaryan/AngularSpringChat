package com.artash.data.dto;

import com.artash.data.entity.Message;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-07-11T17:56:27+0400",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"

)

@Component

public class MessageToDTOMapperImpl implements MessageToDTOMapper {

    @Autowired

    private UserToDTOMapper userToDTOMapper;

    @Override

    public Message MessageDTOToMessage(TestMessageDTO messageDto) {

        if ( messageDto == null ) {

            return null;
        }

        Message message = new Message();

        message.setMessage( messageDto.getMessage() );

        message.setSender( userToDTOMapper.UserDTOToUser( messageDto.getSender() ) );

        message.setReceiver( userToDTOMapper.UserDTOToUser( messageDto.getReceiver() ) );

        return message;
    }

    @Override

    public TestMessageDTO MessageToMessageDTO(Message message) {

        if ( message == null ) {

            return null;
        }

        TestMessageDTO testMessageDTO = new TestMessageDTO();

        testMessageDTO.setSender( userToDTOMapper.UserToUserDTO( message.getSender() ) );

        testMessageDTO.setReceiver( userToDTOMapper.UserToUserDTO( message.getReceiver() ) );

        testMessageDTO.setMessage( message.getMessage() );

        return testMessageDTO;
    }
}

