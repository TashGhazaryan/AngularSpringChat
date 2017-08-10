package com.artash.data.dto;

import com.artash.data.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = UserToDTOMapper.class)

public interface MessageToDTOMapper {
    Message MessageDTOToMessage(TestMessageDTO messageDto);
    TestMessageDTO MessageToMessageDTO(Message message);
}
