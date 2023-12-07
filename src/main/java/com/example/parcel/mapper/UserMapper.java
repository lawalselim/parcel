package com.example.parcel.mapper;

import com.example.parcel.dto.UserDto;
import com.example.parcel.model.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getPassword()
        );
    }
    public static User mapToUser(UserDto userDto){
        return new User (
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getAddress(),
                userDto.getPassword()
        );
    }
}
