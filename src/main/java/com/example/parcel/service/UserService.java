package com.example.parcel.service;
import com.example.parcel.dto.UserDto;
import com.example.parcel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService{
    UserDto getUserById(Long userId);
    UserDto updateUser(UserDto userDto);
        // Other user-related methods{
    UserDto registerUser(UserDto userDto);
   // UserDto loginUser(String email, String password);

}
