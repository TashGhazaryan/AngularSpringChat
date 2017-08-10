package com.artash.data.dto;

import com.artash.data.entity.User;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-07-11T17:56:27+0400",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"

)

@Component

public class UserToDTOMapperImpl implements UserToDTOMapper {

    @Override

    public User UserDTOToUser(UserDto userDto) {

        if ( userDto == null ) {

            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );

        return user;
    }

    @Override

    public UserDto UserToUserDTO(User user) {

        if ( user == null ) {

            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );

        return userDto;
    }
}

