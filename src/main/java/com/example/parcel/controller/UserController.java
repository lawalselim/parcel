package com.example.parcel.controller;

import com.example.parcel.dto.UserDto;
import com.example.parcel.exception.UserNotFoundException;
import com.example.parcel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class  UserController {
    private final UserService userService;

    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getUserByUserId(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        if (userDto.getId().equals(id)) {
            return userService.updateUser(userDto);
        } else {

            throw new UserNotFoundException("User not Found");
        }

    }
    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }
 @PostMapping("/login")
 public UserDto loginUser(@RequestParam String email, @RequestParam String password) {
     return userService.loginUser(email, password);
 }
    // Other user-related endpoints
}
