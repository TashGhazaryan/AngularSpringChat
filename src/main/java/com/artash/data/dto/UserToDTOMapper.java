package com.artash.data.dto;


import com.artash.data.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserToDTOMapper {
    User UserDTOToUser(UserDto userDto);
    UserDto UserToUserDTO(User user);
}
