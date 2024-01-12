package com.example.parcel.service;

import com.example.parcel.model.User;
import com.example.parcel.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Collections;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void add() {
        User user = new User();
        user.setUserName("Test-Name");
        user.setPassword("Test-Password");
        user.setEmail("test@gmail.com");
        user.setFirstName("test-lawal");
        user.setLastName("test-lawal");
        user.setPhoneNumber("08155683218");
        user.setPassword("valcarie123@");
        when(userRepository.save(any(User.class))).thenReturn(user);
        User user1 = userService.add(user);

        assertEquals(user1.getEmail(), user.getEmail());
    }

    @Test
    void getAll() {
        User user = mock(User.class);
        user.setUserName("Test-Name");
        user.setPassword("Test-Password");
        user.setEmail("test@gmail.com");

        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        List<User> userList = userService.getAll();

        assertEquals(userList.size(), 1);
    }


    //Expect this to fail
    @Test
    void getByid() {
        int id = 1;
        userService.getById(2);
        verify(userRepository).getById(id);
    }

    @Test
    void slice() {
    }

    @Test
    void deleteById() {
        int id = 1;
        userService.deleteById(id);
        verify(userRepository).deleteById(id);
    }

    @Test
    void getUserViewDto() {
        userService.getUserViewDto();
        verify(userRepository).findAll();
    }

    @Test
    void getByUserName() {
        String userName = "Test-Name";
        userService.getByUserName(userName);
        verify(userRepository).findByUserName(userName);
    }

    @Test
    void authDeleteByUser() {

    }

}