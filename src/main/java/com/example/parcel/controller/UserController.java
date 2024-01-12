package com.example.parcel.controller;

import com.example.parcel.Messages.GenericResponse;
import com.example.parcel.Request.UserNameUpdateRequest;
import com.example.parcel.dto.UserViewDto;
import com.example.parcel.model.User;
import com.example.parcel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class  UserController {

    private final UserService userService;

    /*
    @GetMapping("/{id}")
    public UserDto getUserByUserId(@PathVariable int id) {
        return userService.getById(id);
    }

     */
    @GetMapping("getById/{id}")
    public User getById(@PathVariable int id) {
        return this.userService.getById(id);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = this.userService.getAll();
        return ResponseEntity.ok(users);
    }


    @PostMapping("createUser")
    public ResponseEntity<?> createUser(@RequestBody @Valid User userCreateDto) {
        this.userService.createUser(userCreateDto);
        return ResponseEntity.ok(new GenericResponse("User Created."));
    }

    /*
    @PostMapping("/create-user")
    public ResponseEntity<?> addUser(@RequestBody @Valid UserDto userDto) {
        this.userService.addUser(userDto);
        return ResponseEntity.ok(SysMessage.USER_SAVED);
    }

     */
    @PutMapping("updateByUsername")
    public ResponseEntity<?> updateByUserName(@RequestBody UserNameUpdateRequest userNameUpdateRequest) {
        userService.updateByUserName(userNameUpdateRequest.getUserId(), userNameUpdateRequest.getUserName());
        return ResponseEntity.ok("success");
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

    @GetMapping("getDto")
    public ResponseEntity<List<UserViewDto>> getDto() {
        List<UserViewDto> users = this.userService.getUserViewDto();
        return ResponseEntity.ok(users);
    }

}























