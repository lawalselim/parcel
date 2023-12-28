package com.example.parcel.controller;

import com.example.parcel.dto.UserDto;
import com.example.parcel.model.User;
import com.example.parcel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parcel.Messages.GenericResponse;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class  UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto getUserByUserId(@PathVariable int id) {
        return userService.getUserById(id);
    }


    @GetMapping("getAll")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = this.userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("slice")
    public ResponseEntity<List<User>> slice(Pageable pageable) {
        List<User> users = this.userService.slice(pageable);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteById(int id) {
        this.userService.deleteById(id);
        return ResponseEntity.ok(new GenericResponse("User deleted..."));
    }

}





















 /* @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        if (userDto.getId().equals(id)) {
            return userService.updateUser(userDto);
        } else {

            throw new UserNotFoundException("User not Found");
        }

    }

    */




  /*  @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }
 @PostMapping("/login")
 public UserDto loginUser(@RequestParam String email, @RequestParam String password) {
     return userService.loginUser(email, password);
 }

   */
// Other user-related endpoints