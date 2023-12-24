package com.example.parcel.controller.auth;
import com.example.parcel.dto.UserDto;
import com.example.parcel.exception.UserAlreadyExistsException;
import com.example.parcel.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    /** The user service. */
    private final UserService userService;

    /**
     * Spring injected constructor.
     * @param userService
     */
    public AuthController( UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok().build();
        //return userService.registerUser(userDto);
    }

   /* @PostMapping("/login")
    public UserDto loginUser(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }

    */
}
