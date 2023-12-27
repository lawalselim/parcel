package com.example.parcel.service;
import com.example.parcel.dto.UserDto;
import com.example.parcel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService{
    UserDto getUserById(Long userId);
    User getById(Long id);
    UserDto updateUser(UserDto userDto);
    List<User> getAll();
        // Other user-related methods{
    UserDto registerUser(UserDto userDto);
    UserDto loginUser(String email, String password);
    void deleteById(Long id);
    User findByEMail(String email);
    //void authDeleteByUser(UserDeleteRequest userDeleteRequest);

}
