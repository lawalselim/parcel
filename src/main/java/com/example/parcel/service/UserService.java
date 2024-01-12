package com.example.parcel.service;

import com.example.parcel.Request.UserDeleteRequest;
import com.example.parcel.dto.UserViewDto;
import com.example.parcel.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService{
    //User add(User createDto);

    User createUser( User createDto);
    //UserDto addUser(UserDto userDto);

    User getById(int id);

    void authDeleteByUser(UserDeleteRequest userDeleteRequest);
    List<User> getAll();

    void deleteById(int id);

    User findByEmail(String email);

    List<User> slice(Pageable pageable);

    User getByUserName(String userName);

    List<UserViewDto> getUserViewDto();
    void updateByUserName(int userId, String userName);

    //UserCreateRequest User(User userCreateDto);
}
