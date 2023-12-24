package com.example.parcel.service;

import com.example.parcel.dto.UserDto;


public interface UserService{
    UserDto getUserById(Long userId);
    UserDto updateUser(UserDto userDto);
        // Other user-related methods{
    UserDto registerUser(UserDto userDto);

    UserDto loginUser(UserDto userDto);
    //UserDto loginUser(String email, String password);

}
