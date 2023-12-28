package com.example.parcel.service;
import com.example.parcel.dto.UserDto;
import com.example.parcel.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService{
    UserDto getUserById(int userId);
    User getById(int id);
   // UserDto updateUser(UserDto userDto);
    List<User> getAll();
    void deleteById(int id);
    User findByEmail(String email);
    List<User> slice(Pageable pageable);

}

// UserDto registerUser(UserDto userDto);
// UserDto loginUser(String email, String password);